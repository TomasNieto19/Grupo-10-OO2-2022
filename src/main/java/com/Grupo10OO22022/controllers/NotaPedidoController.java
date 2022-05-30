package com.Grupo10OO22022.controllers;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.Grupo10OO22022.entities.Curso;
import com.Grupo10OO22022.helpers.ViewRouteHelper;
import com.Grupo10OO22022.models.CarreraModel;
import com.Grupo10OO22022.models.CursoModel;

import com.Grupo10OO22022.services.IAulaService;

import com.Grupo10OO22022.services.ICursoService;
import com.Grupo10OO22022.services.IFechaService;
import com.Grupo10OO22022.services.IFinalService;
import com.Grupo10OO22022.services.IMateriaService;
import com.Grupo10OO22022.services.IProfesorService;



@Controller
@PreAuthorize("hasAnyAuthority('administrador', 'auditoria')")
@RequestMapping("/notaPedido")
public class NotaPedidoController {
	
	
	@Autowired
	@Qualifier("cursoService")
	private ICursoService cursoService;
	
	@Autowired
	@Qualifier("finalService")
	private IFinalService finalService;
	
	@Autowired
	private IAulaService aulaService;
	
	@Autowired
	private IMateriaService materiaService;
	
	@Autowired
	private IProfesorService profesorService;
	
	@Autowired
	private IFechaService fechaService;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@GetMapping("/cursadas")
	public ModelAndView cursadas() {
		
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.NOTA_PEDIDO_CURSADAS);
		
		mAV.addObject("cursadas", cursoService.getAll() );
		
		return mAV;
	}
	
	@GetMapping("/nuevo")
	public ModelAndView mostrarFormularioCursada() {
		ModelAndView mv = new ModelAndView(ViewRouteHelper.NOTA_PEDIDO_FORM_CURSADA);
		mv.addObject("curso", new CursoModel());
		mv.addObject("listaAulas",aulaService.getAll());
		mv.addObject("listaMaterias", materiaService.getAll());
		mv.addObject("listaProfesores", profesorService.getAll());
		mv.addObject("listaFechas", fechaService.getAll());
		return mv;
	}
	@PostMapping("/guardar")
	public String guardar(@ModelAttribute("curso") CursoModel c) {
		cursoService.guardarCurso(modelMapper.map(c, Curso.class));
		return "redirect:/notaPedido/cursadas";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarCursoSeleccionado(int id) {
		cursoService.eliminarCurso(id);
		return "redirect:/notaPedido/cursadas";
	}

	@GetMapping("/finales")
	public ModelAndView listarFinales() {
		
		ModelAndView mv = new ModelAndView(ViewRouteHelper.FINAL_VER_FINALES);
		
		mv.addObject("finales", finalService.listaDeFinales());
		
		return mv;
	}
	
	
}