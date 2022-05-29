package com.Grupo10OO22022.controllers;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.Grupo10OO22022.entities.Departamento;
import com.Grupo10OO22022.helpers.ViewRouteHelper;
import com.Grupo10OO22022.models.DepartamentoModel;
import com.Grupo10OO22022.services.IDepartamentoService;




@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {

	@Autowired
	private IDepartamentoService departamentoService;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	//ANDA
	/*@GetMapping("/listar")
	public String listarDepartamentos(Model modelo) {
		List<Departamento> departamentos = departamentoService.listaDeTodosLosDepartamentos();
		modelo.addAttribute("departamentos", departamentos);
		return ViewRouteHelper.DEPARTAMENTO_VER_DEPARTAMENTOS;
	}*/
	
	@GetMapping("/listar")//url
	public ModelAndView listarDepartamento() {
		ModelAndView mv = new ModelAndView(ViewRouteHelper.DEPARTAMENTO_VER_DEPARTAMENTOS);
		mv.addObject("departamentos", departamentoService.listaDeTodosLosDepartamentos());
		return mv;
	}
	
	
	@GetMapping("/nuevo")
	public ModelAndView mostrarFormularioDeDepartamentos() {
		ModelAndView mv= new ModelAndView(ViewRouteHelper.DEPARTAMENTO_VER_FORM);
		mv.addObject("departamento", new DepartamentoModel());
		return mv;
	}
	
	@PostMapping("/guardar")
	public String guardarDepartamento(@ModelAttribute("departamento") DepartamentoModel d) {
		departamentoService.guardarDepartamento(modelMapper.map(d, Departamento.class));
		return "redirect:/departamentos/listar";
	}
	
	// No anda editar
	/*@GetMapping("/editar/{id}")
	public ModelAndView mostrarFormularioDeEditarDepartamento(@PathVariable int id) {
		ModelAndView mv= new ModelAndView(ViewRouteHelper.DEPARTAMENTO_EDITAR);
		
		mv.addObject("departamento", modelMapper.map(departamentoService.optenerDepartamentoPorId(id), DepartamentoModel.class));
		return mv;
	}
	
	@PostMapping("/{id}")
	public String actualizarDepartamento(@PathVariable int id,@ModelAttribute("departamento") DepartamentoModel d) {
	
		Departamento depExistente= departamentoService.optenerDepartamentoPorId(id);
		Departamento aux= modelMapper.map(d, Departamento.class);
		depExistente.setId(id);
		depExistente.setDepartamento(aux.getDepartamento());
		return "redirect:/departamentos/listar";
		
	}*/
	
	//Funciona perfecto
	@GetMapping("/eliminar/{id}")
	public String eliminarDepartamentoSeleccionado(@PathVariable int id) {
		departamentoService.eliminarDepartamento(id);
		return "redirect:/departamentos/listar";
	}
	
}
