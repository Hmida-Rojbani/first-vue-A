package de.tekup.vue.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import de.tekup.vue.models.UserDB;
import de.tekup.vue.models.WelcomeMsg;

@Controller
public class IndexCtrl {
	
	@GetMapping("/")
	public String getIndex(Model model) {
		WelcomeMsg msg = new WelcomeMsg("Hello GLSI-A", "Welcome to Class");
		model.addAttribute("msg", msg);
		return "index";
	}
	
	@GetMapping("/show/users")
	public String getUsers(Model model) {
		model.addAttribute("listUsers", UserDB.getUsers());
		return "user/show-users";
	}
	
	@GetMapping("/delete/user/{id}")
	public String deleteUser(@PathVariable int id) {
		UserDB.remove(id);
		return "redirect:/show/users";
	}
	
	@GetMapping("/add/user")
	public String addUser(Model model) {
		return "user/add-user";
	}
	

}
