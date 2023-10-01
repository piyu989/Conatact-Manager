package com.smart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.dao.userRepo;
import com.smart.entites.User;
import com.smart.helper.Message;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@Autowired
	public userRepo userrepo;
	
	@RequestMapping("/")
	public String home(Model m) {
		m.addAttribute("tittle","Home - Smart Contact Manager");
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
		m.addAttribute("user",new User());
		return "signup";
	}
	@PostMapping("do_register")
	public String registerUser(@ModelAttribute("user") User user,@RequestParam(value="agreement",defaultValue = "false")Boolean agreement,Model model,HttpSession session) {
		try {
			if(!agreement) {
				System.out.println("you have not accepted terms and condition");
				throw new Exception("not agreed terms and conditioin");
			}
			user.setRole("role");
//			user.setImageUrl(null);
			user.setActiveUser(true);
			System.out.println("agreement "+agreement);
			System.out.println(user);
			User result=this.userrepo.save(user);
			model.addAttribute("user",result);
			session.setAttribute("message", new Message("something went wrong","akert-error"));
			return "signup";
			
		}catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("user",user);
			session.setAttribute("message", new Message("something went wrong"+e.getMessage(),"akert-error"));
			return "signup";
		}
	}
}
