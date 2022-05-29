package com.Grupo10OO22022.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Grupo10OO22022.entities.Materia;
import com.Grupo10OO22022.helpers.ViewRouteHelper;
import com.Grupo10OO22022.models.MateriaModel;
import com.Grupo10OO22022.services.ICarreraService;
import com.Grupo10OO22022.services.IMateriaService;

@Controller
@RequestMapping("/materias")
public class MateriaController {

	@Autowired
	private IMateriaService materiaService;
	
	@Autowired
	private ICarreraService carreraService;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@GetMapping("/listar")
	public ModelAndView listarMaterias() {
		ModelAndView mv= new ModelAndView(ViewRouteHelper.MATERIA_VER_MATERIAS);
		mv.addObject("materias", materiaService.getAll());
		return mv;
	}
	@GetMapping("/nuevo")
	public ModelAndView mostrarFormularioMateria() {
		ModelAndView mv= new ModelAndView(ViewRouteHelper.MATERIA_VER_FORM);
		mv.addObject("materia", new MateriaModel());
		mv.addObject("listaCarreras", carreraService.lista());
		return mv;
	}
	
	@PostMapping("/guardar")
	public String guardar(@ModelAttribute("materia") MateriaModel m) {
		materiaService.guardarMateria(modelMapper.map(m, Materia.class));
		return "redirect:/materias/listar";
	}
	@GetMapping("/eliminar/{id}")
	public String eliminarMateriaSeleccionada(int id) {
		materiaService.eliminarMateria(id);
		return "redirect:/materias/listar";
	}
}
