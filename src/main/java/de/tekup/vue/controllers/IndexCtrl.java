package de.tekup.vue.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import de.tekup.vue.models.User;
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
		model.addAttribute("user", new User());
		return "user/add-user";
	}
	
	@PostMapping("/add/user")
	public String postAddUser(@ModelAttribute("user") @Valid User user, BindingResult result) {
		if(result.hasErrors()) {
			return "user/add-user";
		}
		
		UserDB.add(user);
		return "redirect:/show/users";
	}
	
	
	@GetMapping("/edit/user/{id}")
	public String editUser(@PathVariable int id, Model model) {
		model.addAttribute("user", UserDB.get(id));
		return "user/add-user";
	}

}
