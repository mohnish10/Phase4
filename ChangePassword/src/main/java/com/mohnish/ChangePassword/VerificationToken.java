package com.mohnish.ChangePassword;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class VerificationToken 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long token_id;
	
	private String token;
	
	private Date expirationTime;
	
	private static final int EXPIRATION_TIME = 5;
		
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	
	public VerificationToken(String token,User user)
	{
		
		super();
		this.token = token;
		this.user = user;
		this.expirationTime = this.getTokenExpirationTime();
	}
	
	
	public VerificationToken(String token)
	{
		
		super();
		this.token = token;
		this.expirationTime = this.getTokenExpirationTime();
	}
	
	
	
	public Date getTokenExpirationTime()
	{
		
		Calendar calendar = Calendar.getInstance();
		
		calendar.setTimeInMillis(new Date().getTime());
		
		calendar.add(Calendar.MINUTE, EXPIRATION_TIME);
		
		return new Date(calendar.getTime().getTime());
		
		
		
	}
	
	

}
