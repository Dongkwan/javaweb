package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloViewController {

	@GetMapping("/hello_jsp")
	public String helloView(Model model) {
		System.out.println("helloView.....");
		model.addAttribute("name", "둘리");
		return "hello_view";
	}
}
