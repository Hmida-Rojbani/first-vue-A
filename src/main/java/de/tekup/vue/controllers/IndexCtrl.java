package de.tekup.vue.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexCtrl {
	
	@GetMapping("/")
	public String getIndex(Model model) {
		model.addAttribute("name", "GLSI-A");
		return "index";
	}

}
