package com.Grupo10OO22022.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Grupo10OO22022.entities.Final;

import com.Grupo10OO22022.services.IFinalService;

@Controller
public class FinalController {

	@Autowired
	private IFinalService servicio;
	
	@GetMapping("/finales")//url
	public String listarFinales(Model modelo) {
		List<Final> finales= servicio.listaDeFinales();
		modelo.addAttribute("finales",finales);
		return "finales";//finales.html
	}
	
	@GetMapping("/finales/nuevo")
	public String mostrarFormularioDeFinales(Model modelo) {
		Final f1=new Final();
		modelo.addAttribute("final",f1);
		return "form_final";
	}
	
	@PostMapping("/finales")
	public String guardarFinal(@ModelAttribute("final") Final f) {
		servicio.guardarFinal(f);
		return "redirect:/finales";
	}
	
	@GetMapping("/finales/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable int id, Model modelo) {
		modelo.addAttribute("final",servicio.obtenerFinalPorId(id));
		return "editar_final";
	}
	
	@PostMapping("/finales/editar/{id}")
	public String actualizarFinal(@PathVariable int id,@ModelAttribute("final")Final f, Model modelo) {
		Final finalExistente= servicio.obtenerFinalPorId(id);
		
		finalExistente.setId(id);
		finalExistente.setMesa(f.getMesa());
		finalExistente.setFecha(f.getFecha());
		
		return "redirect:/finales";
	}
}
