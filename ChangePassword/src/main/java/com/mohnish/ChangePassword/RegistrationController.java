package com.mohnish.ChangePassword;

import java.io.UnsupportedEncodingException;
import java.util.Optional;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegistrationController 
{
	
	private final UserService userService;
	private final ApplicationEventPublisher publisher;
	private final VerificationTokenRepository tokenRepository;
	private final RegistrationCompleteEventListener eventListener;
	@Autowired(required=true)
	private final HttpServletRequest servletRequest;
	
	
	@PostMapping
	public String registerUser(@RequestBody RegistrationRequest registrationRequest, final HttpServletRequest request)
	{
		
		User user = userService.registerUser(registrationRequest);
		publisher.publishEvent(new RegistrationCompleteEvent(user,applicationUrl(request)));
		return "Success, please check your email to complete registration";
		
	}
	
	
	public String applicationUrl(HttpServletRequest request)
	{
		
		return "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
	}
	
	
	@GetMapping("/verifyEmail")
	public String sendVerificationToken(@RequestParam("token") String token)
	{
		
		String url = applicationUrl(servletRequest)+"/register/resend-verification-token?token="+token;
		
		VerificationToken theToken = tokenRepository.findByToken(token);
		
		if(theToken.getUser().isEnabled())
		return "this account has been verified,please login";
		
		
		String verificationResult = userService.validateToken(token);
		
		if(verificationResult.equalsIgnoreCase("valid"))
		return "Email verified successfully. Now you can login to your account.";
		
		return "Invalid verification link, <a href=\""+url+"\"> Get a new verification link. </a>";
	}
	

	@GetMapping("/resend-verification-token")
	public String resendVerificationToken(@RequestParam("token") String oldToken,final HttpServletRequest request) throws MessagingException,UnsupportedEncodingException
	{
		
		VerificationToken verificationToken = userService.generateNewVerificationToken(oldToken);
		
		User theUser = verificationToken.getUser();
		
		resendRegistrationVerificationTokenEmail(theUser,applicationUrl(request),verificationToken);
		
		return "A new verification email has been sent to your email,"+"please, check to activate your account";
		
	}
	
	
	private void resendRegistrationVerificationTokenEmail(User theUser,String applicationUrl,VerificationToken verificationToken) throws MessagingException,UnsupportedEncodingException
	{
		
		String url = applicationUrl+"/register/verifyEmail?token="+verificationToken.getToken();
		
		eventListener.sendVerificationEmail(url);
		
		log.info("Click the link to verify your registration : {}",url);
		
	}
	
	
	@PostMapping("/password-reset-request")
	public String resetPasswordRequest(@RequestBody PasswordRequestUtil passwordRequestUtil,final HttpServletRequest servletRequest) throws MessagingException,UnsupportedEncodingException
	{
		
		Optional<User> user = userService.findByEmail(passwordRequestUtil.getEmail());
		
		String passwordResetUrl = "";
		
		if(user.isPresent())
		{
			
			String passwordResetToken = UUID.randomUUID().toString();
			
			userService.createPasswordResetTokenForUser(user.get(), passwordResetToken);
			
			passwordResetUrl = passwordResetEmailLink(user.get(),applicationUrl(servletRequest),passwordResetToken);
		}
		
		return passwordResetUrl;
		
	}
	
	
	private String passwordResetEmailLink(User user,String applicationUrl,String passwordToken) throws MessagingException,UnsupportedEncodingException
	{
		
		String url = applicationUrl+"/register/reset-password?token="+passwordToken;
		
		eventListener.sendPasswordResetVerificationEmail(url);
		
		log.info("Click the link to reset your password : {}",url);
		
		return url;
	}
	
	
	@PostMapping("/reset-password")
	public String resetPassword(@RequestBody PasswordRequestUtil passwordRequestUtil,@RequestParam("token") String token)
	{
		
		String tokenVerificationResult = userService.validatePasswordResetToken(token);
		
		if(!tokenVerificationResult.equalsIgnoreCase("valid"))
		return "Invalid token password reset token";
		
		Optional<User> theUser = Optional.ofNullable(userService.findUserByPasswordToken(token));
		
		if(theUser.isPresent())
		{
			
			userService.changePassword(theUser.get(),passwordRequestUtil.getNewPassword());
			return "Password has been reset successfully";
		}
		
		return "Invalid password reset token";
	}
	
	
	@PostMapping("/change-password")
	public String changePassword(@RequestBody PasswordRequestUtil requestUtil)
	{
		
		User user = userService.findByEmail(requestUtil.getEmail()).get();
		
		if(!userService.oldPasswordIsValid(user,requestUtil.getOldPassword()))
		return "Incorrect old password";
		
		userService.changePassword(user,requestUtil.getNewPassword());
		
		return "Password changed successfully";
		
		
	}
		
		
	
	
	
	
	

}
