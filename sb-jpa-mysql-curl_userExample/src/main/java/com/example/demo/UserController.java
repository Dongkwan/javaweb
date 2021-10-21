package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller // This means that this class is a Controller
@RequestMapping(path = "/user") // This means URL's start with /demo (after Application path)
public class UserController {
	@Autowired 	// This means to get the bean called userRepository
				// Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepository;

	@GetMapping("/insertUser")
	public String insertBoardView() {
		return "user/insertUser";
	}

	@PostMapping("/insertUser")
	public String insertUser(User user) {
		userRepository.save(user);
		return "redirect:getUserList";
	}

	@RequestMapping("/getUserList")
	public String getUserList(Model model, User user) {		
		System.out.println("getUserList called...");
		Iterable<User> userList = userRepository.findAll();
		model.addAttribute("userList", userList);
		return "user/getUserList";
	}

	@GetMapping("/getUser")
	public String getUser(User user, Model model) {
		System.out.println(userRepository.findById(user.getId()).toString());
		model.addAttribute("user", userRepository.findById(user.getId()).get());
		return "user/getUser";
	}	

	
	@PostMapping(path = "/add") // Map ONLY POST Requests
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		User n = new User();
		n.setName(name);
		n.setEmail(email);
		userRepository.save(n);
		return "Saved";
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
}