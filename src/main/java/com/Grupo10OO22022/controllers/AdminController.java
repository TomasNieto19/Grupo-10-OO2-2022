package com.Grupo10OO22022.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.Grupo10OO22022.helpers.ViewRouteHelper;

@Controller
@PreAuthorize("hasAuthority('administrador')")
@RequestMapping("/admin")
public class AdminController {
	
	@GetMapping("")
	public String index() {
		return ViewRouteHelper.ADMIN_INDEX;
	}
	
	@GetMapping("/index")
	public RedirectView RedirectIndex() {
		return new RedirectView("");
	}
}
