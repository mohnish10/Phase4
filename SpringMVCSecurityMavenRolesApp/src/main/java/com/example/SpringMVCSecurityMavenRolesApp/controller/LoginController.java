package com.example.SpringMVCSecurityMavenRolesApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController 
{
	
	@GetMapping("/")
	public ModelAndView welcomePage()
	{
		
		ModelAndView model = new ModelAndView();
		model.setViewName("welcomePage");
		return model;
	}
	
	
	@GetMapping("/homePage")
	public ModelAndView homePage()
	{
		
		ModelAndView model = new ModelAndView();
		model.setViewName("homePage");
		return model;
	}
	
	
	@GetMapping("/loginPage")
	public ModelAndView loginPage(@RequestParam(value="error",required=false) String error,@RequestParam(value="logout",required=false) String logout)
	{
		
		ModelAndView model = new ModelAndView();
		if(error!=null)
		{
			model.addObject("error","Invalid credentials provided.");
		}
		if(logout!=null)
		{
			
			model.addObject("message","Logged out from JournalDEV successfully.");
		}
		model.setViewName("loginPage");
		return model;
		
	}
	
	
	
	

}
