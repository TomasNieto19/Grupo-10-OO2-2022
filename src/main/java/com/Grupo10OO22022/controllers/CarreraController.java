package com.Grupo10OO22022.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Grupo10OO22022.entities.Carrera;
import com.Grupo10OO22022.entities.Departamento;
import com.Grupo10OO22022.helpers.ViewRouteHelper;
import com.Grupo10OO22022.models.CarreraModel;
import com.Grupo10OO22022.models.DepartamentoModel;
import com.Grupo10OO22022.services.ICarreraService;
import com.Grupo10OO22022.services.IDepartamentoService;

@Controller
@RequestMapping("/carreras")
public class CarreraController {

	@Autowired
	private ICarreraService carreraService;
	
	@Autowired
	private IDepartamentoService departamentoService;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	
	@GetMapping("/listar")
	public ModelAndView listarCarreras() {
		ModelAndView mv= new ModelAndView(ViewRouteHelper.CARRERA_VER_CARRERAS);
		mv.addObject("carreras", carreraService.lista());
		return mv;
	}
	
	@GetMapping("/nuevo")
	public ModelAndView mostrarFormularioCarrera() {
		ModelAndView mv= new ModelAndView(ViewRouteHelper.CARRERA_VER_FORM);
		mv.addObject("carrera", new CarreraModel());
		mv.addObject("listaDepartamentos", departamentoService.listaDeTodosLosDepartamentos());
		return mv;
	}
	
	@PostMapping("/guardar")
	public String guardar(@ModelAttribute("carrera") CarreraModel c) {
		carreraService.guardarCarrera(modelMapper.map(c, Carrera.class));
		return "redirect:/carreras/listar";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarCarreraSeleccionada(int id) {
		carreraService.eliminarCarrera(id);
		return "redirect:/carreras/listar";
	}
}
