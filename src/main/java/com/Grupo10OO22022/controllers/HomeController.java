package com.Grupo10OO22022.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {

	@GetMapping("")
	public String index() {
		
		return "home/index";
		// IR a: http://localhost:8080
	}
	
}



