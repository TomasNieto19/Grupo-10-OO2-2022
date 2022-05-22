package com.Grupo10OO22022.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Grupo10OO22022.entities.Final;

import com.Grupo10OO22022.services.IFinalService;

@Controller
public class FinalController {

	@Autowired
	private IFinalService servicio;
	
	@GetMapping("/finales")
	public String listarFinales(Model modelo) {
		modelo.addAttribute("finales",servicio.listaDeFinales());
		return "finales";
	}
	
	@GetMapping("/finales/nuevo")
	public String mostrarFormularioFinales(Model modelo) {
		
		Final finalPedido=new Final();
		modelo.addAttribute("final",finalPedido);
		return "crear_Final_Pedido";
	}
	
	@PostMapping("/finales")
	public String guardarFinal(@ModelAttribute("finalPedido") Final f) {
		servicio.guardarFinal(f);
		return "redirect:/finales";
	}
}
