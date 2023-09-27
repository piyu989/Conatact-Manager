package com.smart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


//import com.smart.dao.userRepo;
//import com.smart.entites.Contact;
//import com.smart.entites.User;

@Controller
public class HomeController {
//	@Autowired
//	public userRepo userrepo;
	
	@RequestMapping("/")
	public String home(Model m) {
//		User user=new User();
//		user.setName("Piyush");
//		user.setAboutUser("Trader");
//		user.setActiveUser(true);
//		user.setRole("master");
//		
//		Contact c=new Contact();
//		user.getLi().add(c);
//		userrepo.save(user);
		m.addAttribute("tittle","Home - Smart Contact Manager");
//		
		return "home";
	}
	
	@RequestMapping("/about")
	public String about(Model m) {
		m.addAttribute("tittle","about page");
		return "about";
	}
	@RequestMapping("/signup")
	public String signup(Model m) {
		m.addAttribute("tittle","register - about sontact manager");
		return "signup";
	}
}
