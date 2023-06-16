package com.mohnish.SpringSecurityClient.controller;

import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mohnish.SpringSecurityClient.entity.User;
import com.mohnish.SpringSecurityClient.entity.VerificationToken;
import com.mohnish.SpringSecurityClient.event.RegistrationCompleteEvent;
import com.mohnish.SpringSecurityClient.model.PasswordModel;
import com.mohnish.SpringSecurityClient.model.UserModel;
import com.mohnish.SpringSecurityClient.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RegistrationController 
{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	@PostMapping("/register")
	public String registerUser(@RequestBody UserModel userModel,final HttpServletRequest request)
	{
		
		User user = userService.registerUser(userModel);
		publisher.publishEvent(new RegistrationCompleteEvent(user,applicationUrl(request)));
		
		return "Success";
	}
	
	
	@GetMapping("/verifyRegistration")
	private String verifyRegistration(@RequestParam("token") String token)
	{
		
		String result = userService.validateVerificationToken(token);
		
		if(result.equalsIgnoreCase("valid"))
		{
			
			return "User verified successfully";
		}
		
		return "Bad User";
	}
	
	
	@GetMapping("/resendVerifyToken")
	public String resendVerificationToken(@RequestParam("token") String oldToken,HttpServletRequest request)
	{
		
		VerificationToken verificationToken = userService.generateNewVerificationToken(oldToken);
		
		User user = verificationToken.getUser();
		
		resendVerificationTokenMail(user,applicationUrl(request),verificationToken);
		
		return "Verification Link Sent";
		
	}
	
	
	@PostMapping("/resetPassword")
	public String resetPassword(@RequestBody PasswordModel passwordModel,HttpServletRequest request)
	{
		
		User user = userService.findUserByEmail(passwordModel.getEmail());
		
		String url = "";
		
		if(user!=null)
		{
			
			String token = UUID.randomUUID().toString();
			userService.createPasswordResetTokenForUser(user,token);
			url = passwordResetTokenMail(user,applicationUrl(request),token);
		}
		
		return url;
	}
	
	
	@PostMapping("/savePassword")
	public String savePassword(@RequestParam("token") String token,@RequestBody PasswordModel passwordModel)
	{
		
		String result = userService.validatePasswordResetToken(token);
		
		if(!result.equalsIgnoreCase("valid"))
		{
			
			return "Invalid token";
		}
		
		Optional<User> user = userService.getUserByPasswordResetToken(token);
		
		if(user.isPresent())
		{
			
			userService.changePassword(user.get(),passwordModel.getNewPassword());
			return "Password Reset Successfully";
		}
		else
		{
			
			return "Invalid token";
		}
		
	}
	
	
	@PostMapping("/changePassword")
	public String changePassword(@RequestBody PasswordModel passwordModel)
	{
		
		User user = userService.findUserByEmail(passwordModel.getEmail());
		
		if(!userService.checkIfValidOldPassword(user,passwordModel.getOldPassword()))
		return "Invalid Old Password";
		
		userService.changePassword(user,passwordModel.getNewPassword());
		return "Password changed successfully";
	}
	
	
	private String passwordResetTokenMail(User user,String applicationUrl,String token)
	{
		
		String url = applicationUrl + "/savePassword?token=" + token;
		
		log.info("Click the link to reset your password: {}",url);
		
		return url;
	}
	
	
	private void resendVerificationTokenMail(User user,String applicationUrl, VerificationToken verificationToken)
	{
		
		String url = applicationUrl + "/verifyRegistration?token=" + verificationToken.getToken();
		
		log.info("Click the link to verify your account: {}",url);
	}
	
	
	
	
	private String applicationUrl(HttpServletRequest request)
	{
		
		return "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
	}
	
	
	
	
	
	
	
	

}
