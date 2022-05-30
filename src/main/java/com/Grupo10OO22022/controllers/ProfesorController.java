package com.Grupo10OO22022.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Grupo10OO22022.entities.Profesor;
import com.Grupo10OO22022.helpers.ViewRouteHelper;
import com.Grupo10OO22022.models.ProfesorModel;
import com.Grupo10OO22022.services.IProfesorService;

@Controller
@RequestMapping("/profesores")
public class ProfesorController {
	
	@Autowired
	private IProfesorService profesorService;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@GetMapping("/listar")
	public ModelAndView listarProfesores() {
		ModelAndView mv= new ModelAndView(ViewRouteHelper.PROFESOR_VER_PROFESORES);
		mv.addObject("profesores", profesorService.getAll());
		return mv;
	}
	
	
	@GetMapping("/nuevo")
	public ModelAndView mostrarFormularioProfesor() {
		ModelAndView mv= new ModelAndView(ViewRouteHelper.PROFESOR_VER_FORM);
		mv.addObject("profesor", new ProfesorModel());
		return mv;
	}
	
	@PostMapping("/guardar")
	public String guardarProfe(@ModelAttribute("profesor") ProfesorModel p) {
		profesorService.guardarProfesor(modelMapper.map(p, Profesor.class));
		return "redirect:/profesores/listar";
	}
	@GetMapping("/eliminar/{id}")
	public String eliminarProfesorSeleccionado(int id) {
		profesorService.eliminarProfesor(id);
		return "redirect:/profesores/listar";
	}
}
