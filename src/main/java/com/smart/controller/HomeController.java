package com.smart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.dao.userRepo;
import com.smart.entites.User;
import com.smart.helper.Message;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

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
<<<<<<< HEAD
	public String registerUser(@Valid @ModelAttribute("user") User user,BindingResult result,@RequestParam(value="agreement",defaultValue = "false")
								boolean agreement,Model model,HttpSession session) {
=======
	public String registerUser(@ModelAttribute("user") User user,@RequestParam(value="agreement",defaultValue = "false")boolean agreement,Model model,HttpSession session) {
>>>>>>> baa6e7d1476679bb7f2c1009427048f0542313c0
		try {
			if(!agreement) {
				System.out.println("not accpeted");
				throw new Exception("you have not conformend privacy");
			}
<<<<<<< HEAD
			if(result.hasErrors()) {
				model.addAttribute("user",user);
				return "signup";
			}
=======
>>>>>>> baa6e7d1476679bb7f2c1009427048f0542313c0
			user.setRole("java developer");
			user.setActiveUser(true);
			User u=this.userrepo.save(user);
			model.addAttribute("user",user);
			session.setAttribute("message",new Message("done completely","alert-success"));
			return "signup";
		}catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("user",user);
			session.setAttribute("message",new Message("something went wrong"+e.getMessage(),"alert-danger"));
			return "signup";
		}
	}
}
