package com.Grupo10OO22022.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.Grupo10OO22022.helpers.ViewRouteHelper;

@Controller
@RequestMapping("")
public class HomeController {

	@GetMapping("/index")
	public String index() {

		return ViewRouteHelper.INDEX;

	}

	// Permite el funcionamiento de los botones (navbar)
	@GetMapping("")
	public RedirectView home() {
		
		return new RedirectView("/index");
		
	}

	@GetMapping("/about")
	public String about() {

		return ViewRouteHelper.ABOUT;

	}

	@GetMapping("/contact")
	public String contact() {

		return "home/contact";

	}
	
}



