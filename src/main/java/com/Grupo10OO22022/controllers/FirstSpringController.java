package com.Grupo10OO22022.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/firstspring")
public class FirstSpringController {

	@GetMapping("HelloWorld")
	public String helloWorld() {
		
		return "HelloWorld";
		// IR a: http://localhost:8080/firstspring/HelloWorld
	}
	
}


	
