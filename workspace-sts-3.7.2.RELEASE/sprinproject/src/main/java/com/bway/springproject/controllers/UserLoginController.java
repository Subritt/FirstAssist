package com.bway.springproject.controllers;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bway.springproject.HomeController;
import com.bway.springproject.daos.StudentDao;
import com.bway.springproject.daos.UserDao;
import com.bway.springproject.model.User;

@Controller
public class UserLoginController {

	private static final Logger logger = LoggerFactory.getLogger(UserLoginController.class);
	
	@Autowired
	private UserDao udao;

	@Autowired
	private StudentDao sdao;

	@RequestMapping(value = "/userlogin", method = RequestMethod.GET)
	public String getLoginForm() {

		logger.info("Inside Login Form");
		
		return "login";
	}

	@RequestMapping(value = "/userlogin", method = RequestMethod.POST)
	public String userLogin(@ModelAttribute User u, Model model, HttpServletRequest req, HttpSession session)
			throws IOException {

//		String input = req.getParameter("g-recaptcha-response");
//		boolean verify = VerifyRecaptcha.verify(input);

//		if (verify == true) {

			if (udao.login(u.getUsername(), u.getPassword())) {
				
				logger.info("login successfull");

				session.setAttribute("username", u.getUsername());
				session.setMaxInactiveInterval(10 * 60);

				model.addAttribute("user", u.getUsername());
				model.addAttribute("slist", sdao.getAllStudent());

				return "home";
			} else {

				logger.info("login failed");
				
				model.addAttribute("error", "user not registered");
				return "login";
			}

//		}
//		model.addAttribute("error", "you are not human!!");
//
//		return "login";

	}

	@RequestMapping(value = "/facebook", method = RequestMethod.GET)
	public String fbLogin() {

		// String secret_key = "c85c3bbaeded9ce1ea6af891cc8733c2";
		// String app_id = "1439123129660532";

		return "redirect:https://www.facebook.com/dialog/oauth?client_id=381726895655302&redirect_uri=http://localhost:8080/springproject/authorize/facebook&response_type=code&scope=email";
	}

	@RequestMapping(value = "/authorize/facebook", method = RequestMethod.GET)
	public String saveFbUser(String code, Model model, HttpServletRequest request) {

		model.addAttribute("slist", sdao.getAllStudent());

		return "home";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {

		logger.info("user logout success");
		session.invalidate();

		return "login";

	}

}
