package com.mohnish.ChangePassword;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.context.ApplicationListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent>
{
	
	private final UserService userService;
	private final JavaMailSender mailSender;
	private User theUser;
	
	
	@Override
	public void onApplicationEvent(RegistrationCompleteEvent event) 
	{
		
		theUser = event.getUser();
		
		String verificationToken = UUID.randomUUID().toString();
		
		userService.saveUserVerificationToken(theUser,verificationToken);
		
		String url = event.getApplicationUrl() + "/register/verifyEmail?token="+verificationToken;
		
		try
		{
			
			sendVerificationEmail(url);
			
		}
		catch(MessagingException | UnsupportedEncodingException e)
		{
			
			e.printStackTrace();
		}
		
		log.info("Click the link to verify your registration : {}",url);

	}
	
	
	public void sendVerificationEmail(String url) throws MessagingException,UnsupportedEncodingException
	{
		
		String subject = "Email Verification";
		String senderName = "User Registration Portal Service";
		String mailContent = "<p> Hi,"+theUser.getFirstName()+", <p>"+"<p>Thank you for registering with us,"+""+"Please, follow the link below to complete your registration.</p>"+"<a href=\""+url+"\">Verify your email to activate your account</a>"+
		"<p> Thank you <br> Users Registration Portal Service";
		
		MimeMessage message = mailSender.createMimeMessage();
		
		var messageHelper = new MimeMessageHelper(message);
		
		messageHelper.setFrom("dailycodework@gmail.com",senderName);
		
		messageHelper.setTo(theUser.getEmail());
		
		messageHelper.setSubject(subject);
		
		messageHelper.setText(mailContent,true);
		
		mailSender.send(message);
		
	}
	
	
	public void sendPasswordResetVerificationEmail(String url) throws MessagingException,UnsupportedEncodingException
	{
		
		String subject = "Password Reset Request Verification";
		
		String senderName = "User Registration Portal Service";
		
		String mailContent = "<p> Hi, "+theUser.getFirstName()+", <p>"+
		"<p><b>You recently requested to reset your password,</b>"+""+
		"Please, follow the link below to complete the action.</p>"+
		"<a href=\""+url+"\">Reset password</a>"+
		"<p> Users Registration Portal Service";
		
		MimeMessage message = mailSender.createMimeMessage();
		
		var messageHelper = new MimeMessageHelper(message);
		
		messageHelper.setFrom("dailycodework@gmail.com",senderName);
		
		messageHelper.setTo(theUser.getEmail());
		
		messageHelper.setSubject(subject);
		
		messageHelper.setText(mailContent,true);
		
		mailSender.send(message);
				
		
		
		
		
	}
	
	
	
	
	
	

}
