package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	@GetMapping("/")
	public String loginView() {
		return "loginView";	//loginView.jsp
	}
	
	@PostMapping("/login")
	public String login(Model model, String username, String password) {
		System.out.println("login controller");
		System.out.println(username + ", " + password);
		
		model.addAttribute("username", username);
		
		if(username.equals("member") && password.equals("pass")) {
			return "loginSuccess"; //loginSuccess.jsp
		}else {
			return "loginError";	//loginError.jsp
		} 
	}
}
