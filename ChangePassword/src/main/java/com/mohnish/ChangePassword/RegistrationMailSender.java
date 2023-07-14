package com.mohnish.ChangePassword;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegistrationMailSender 
{
	
	private final JavaMailSender mailSender;
	private final RegistrationCompleteEvent event;
	
	
	public void sendVerificationEmail(String url) throws MessagingException, UnsupportedEncodingException
	{
		
		String subject = "Email Verification";
		String senderName = "User Registration Portal Service";
		String mailContent = "<p> Hi,"+event.getUser().getFirstName()+",</p>"
		+"<p> Thank you for registering with us,"+""+"Please, follow the link below to complete your registration.</p>"
		+"<a href=\""+url+"\">Verify your email to activate your account</a>"+
		"<p> Thank you <br> Users Registration Portal Service";
		
		MimeMessage message = mailSender.createMimeMessage();
		
		var messageHelper = new MimeMessageHelper(message);
		
		messageHelper.setFrom("dailycodework@gmail.com",senderName);
		
		messageHelper.setTo(event.getUser().getEmail());
		
		messageHelper.setSubject(subject);
		
		messageHelper.setText(mailContent,true);
		
		mailSender.send(message);
		
}
	
	
	

}
