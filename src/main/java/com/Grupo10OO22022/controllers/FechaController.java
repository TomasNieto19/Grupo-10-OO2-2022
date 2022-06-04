package com.Grupo10OO22022.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Grupo10OO22022.entities.Curso;
import com.Grupo10OO22022.entities.Fecha;
import com.Grupo10OO22022.helpers.ViewRouteHelper;
import com.Grupo10OO22022.models.CursoModel;
import com.Grupo10OO22022.services.IFechaService;

@Controller
@RequestMapping("/fechas")
public class FechaController {
	@Autowired
	private IFechaService fechaService;
	
	@GetMapping("/nuevaFecha")
	public ModelAndView mostrarFormularioFecha() {
		ModelAndView mv = new ModelAndView(ViewRouteHelper.NOTA_PEDIDO_FORM_CURSADA);
		mv.addObject("fecha", new Fecha(null, null));
		return mv;
	}
	@PostMapping("/guardarFecha")
	public String guardar(@ModelAttribute("fecha") Fecha f) {
		fechaService.guardarFecha(f);
		return ViewRouteHelper.NOTA_PEDIDO_FORM_CURSADA;
	}

	
}
