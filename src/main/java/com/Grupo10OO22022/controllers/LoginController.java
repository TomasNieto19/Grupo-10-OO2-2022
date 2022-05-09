package com.Grupo10OO22022.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Grupo10OO22022.helpers.ViewRouteHelper;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login(Model model, @RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {

		model.addAttribute("error", error);

		model.addAttribute("logout", logout);

		return ViewRouteHelper.USER_LOGIN;
	}

	// Al cerrar la session, el usuario vuelve a la vista de Login
	@GetMapping("/logout")
	public String logout(Model model) {

		// return ViewRouteHelper.USER_LOGOUT;
		return ViewRouteHelper.USER_LOGIN;
	}

	// Si el login es correcto, el usuario va al index.
	@GetMapping("/loginsuccess")
	public String loginCheck() {

		return "redirect:/index";

	}

}
