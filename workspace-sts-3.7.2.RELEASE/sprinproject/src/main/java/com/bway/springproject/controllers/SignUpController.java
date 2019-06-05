package com.bway.springproject.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bway.springproject.daos.UserDao;
import com.bway.springproject.model.User;

@Controller
public class SignUpController {
	
	private static final Logger logger = LoggerFactory.getLogger(SignUpController.class);

	
	@Autowired
	private UserDao udao;
	
	@RequestMapping(value="/userreg", method = RequestMethod.GET)
	public String getSignup(){
		
		logger.info("Inside SignUp form");
		
		return "signup" ;
	}
	
	@RequestMapping(value="/userreg", method = RequestMethod.POST)
	public String Signup(@ModelAttribute User u){
		
		udao.signup(u);
		
		return "login";
		
	}

}
