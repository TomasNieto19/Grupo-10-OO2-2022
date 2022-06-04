package com.Grupo10OO22022.controllers;




import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;


import com.Grupo10OO22022.entities.Curso;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


import com.Grupo10OO22022.entities.Curso;
import com.Grupo10OO22022.entities.Espacio;
import com.Grupo10OO22022.entities.Fecha;
import com.Grupo10OO22022.entities.Final;



import com.Grupo10OO22022.helpers.EspacioFiltros;

import com.Grupo10OO22022.helpers.ViewRouteHelper;
import com.Grupo10OO22022.models.CarreraModel;
import com.Grupo10OO22022.models.CursoModel;
import com.Grupo10OO22022.models.FechaModel;
import com.Grupo10OO22022.models.FinalModel;
import com.Grupo10OO22022.services.IAulaService;

import com.Grupo10OO22022.services.ICursoService;

import com.Grupo10OO22022.services.IEspacioService;

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
	
	
	
	private ModelMapper modelMapper = new ModelMapper();

	@Qualifier("espacioService")
	private IEspacioService espacioService;
	
	@Autowired
	@Qualifier("fechaService")
	private IFechaService fechaService;
	

	
	@GetMapping("/cursadas")
	public String listarCursadas(Model model, @Param("keyword") String keyword) {
		
		//Esta consulta puede devolver objetos repetidos.
		List<Curso> cursadasRepetidas = this.cursoService.listAll(keyword);
		
		//Nueva lista para agregar objetos sin repetir.
		List<Curso> cursadas = new ArrayList<Curso>();
		
		//Si el objeto ya está, no lo vuelve agregar.
		for (Curso objeto : cursadasRepetidas) {
			
	          if ( !cursadas.contains(objeto) ) {
	        	  
	        	  cursadas.add(objeto);
	            
	          }
	    }
		
		model.addAttribute("cursadas", cursadas);
		
		model.addAttribute("keyword", keyword);
		
		return ViewRouteHelper.NOTA_PEDIDO_CURSADAS;
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
	public String eliminarCursoSeleccionado(@PathVariable("id") int id) {
		/*//Si se quiere eliminar de la base de datos, se hace esto
		cursoService.eliminarCurso(id);
		return "redirect:/notaPedido/cursadas";*/
		
		//Oculto de la vista, pero sigue estando en la base de datos
		Curso curso =cursoService.getById(id);
		curso.setActivo(false);
		
		cursoService.guardarCurso(curso);
		return "redirect:/notaPedido/cursadas";
	}

	@GetMapping("/finales")
	public String listarFinales(Model model, @Param("keyword") String keyword) {
		
		List<Final> finalesRepetidos = this.finalService.listAll(keyword);
		
		List<Final> finales = new ArrayList<Final>();
		

		for (Final objeto : finalesRepetidos) {
			
	          if (!finales.contains(objeto)) {
	        	  
	            finales.add(objeto);
	            
	          }
	    }
		
		model.addAttribute("finales", finales);
		
		model.addAttribute("keyword", keyword);
		
		return ViewRouteHelper.NOTA_PEDIDO_FINALES;
	}
	
	

	
	@GetMapping("/detalleCursada/{id}")
	public ModelAndView detallarCursada(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView(ViewRouteHelper.NOTA_PEDIDO_DETALLE_CURSADA);
		mv.addObject("curso", cursoService.getById(id));
		mv.addObject("espacios", new ArrayList<Espacio>());
		return mv;
	}
	
	@GetMapping("/traerEspacios/{id}/{id_fecha}")
	public ModelAndView traerEspacios(@PathVariable("id") int id, @PathVariable("id_fecha") int id_fecha) {
		ModelAndView mv = new ModelAndView(ViewRouteHelper.NOTA_PEDIDO_DETALLE_CURSADA);
		Curso curso = cursoService.getById(id);
		Fecha fecha = fechaService.getbyId(id_fecha);
		EspacioFiltros filtro = new EspacioFiltros(fecha.getFecha(), fecha.getFecha(), true, false, false, false, false);
		if (curso.getTurno()=='M') 
			filtro.setManiana(true);
		else if (curso.getTurno()=='T')
			filtro.setTarde(true);
		else 
			filtro.setNoche(true);
		mv.addObject("fechaActual_id", fecha.getId());
		mv.addObject("curso", curso);
		mv.addObject("espacios", espacioService.traerPorFiltros(filtro));
		return mv;
	}
	

	@GetMapping("/nuevoFinal")
	public ModelAndView mostrarFormularioFinal() {
		ModelAndView mv = new ModelAndView(ViewRouteHelper.NOTA_PEDIDO_FORM_FINAL);
		mv.addObject("final", new FinalModel());
		mv.addObject("listaAulas",aulaService.getAll());
		mv.addObject("listaMaterias", materiaService.getAll());
		mv.addObject("listaProfesores", profesorService.getAll());
		mv.addObject("listaFechas", fechaService.getAll());
		return mv;
	}

	@GetMapping("/asignarEspacioCurso/{id}/{id_fecha}/{id_espacio}")
	public RedirectView asignarEspacioCurso(@PathVariable("id") int id, @PathVariable("id_fecha") int id_fecha,
										@PathVariable("id_espacio") int id_espacio) {
		Fecha fecha = fechaService.getbyId(id_fecha);
		Espacio espacio = espacioService.getById(id_espacio);
		fecha.setEspacioAsignado(espacio);
		fechaService.modificarFecha(fecha);
		espacio.setLibre(false);
		espacioService.modificarEspacio(espacio);
		cursoService.verificarPendiente(cursoService.getById(id));
		return new RedirectView("/notaPedido/detalleCursada/"+id);
	}
	
	
	@GetMapping("/detalleFinal/{id}")
	public ModelAndView detallarFinal(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView(ViewRouteHelper.NOTA_PEDIDO_DETALLE_FINAL);
		Final notaFinal = finalService.getById(id);
		EspacioFiltros filtro = new EspacioFiltros(notaFinal.getFecha().getFecha(), notaFinal.getFecha().getFecha(), true, false, false, false, false);
		if (notaFinal.getTurno()=='M') 
			filtro.setManiana(true);
		else if (notaFinal.getTurno()=='T')
			filtro.setTarde(true);
		else 
			filtro.setNoche(true);
		mv.addObject("final", notaFinal);
		mv.addObject("espacios", espacioService.traerPorFiltros(filtro));
		return mv;
	}
	
	@GetMapping("/asignarEspacioFinal/{id}/{id_espacio}")
	public RedirectView asignarEspacio(@PathVariable("id") int id, @PathVariable("id_espacio") int id_espacio) {
		Espacio espacio = espacioService.getById(id_espacio);
		Final notaFinal = finalService.getById(id);
		notaFinal.getFecha().setEspacioAsignado(espacio);
		fechaService.modificarFecha(notaFinal.getFecha());
		espacio.setLibre(false);
		espacioService.modificarEspacio(espacio);
		notaFinal.setPendiente(false);
		return new RedirectView("/notaPedido/detalleFinal/"+id);
	}

	
	@PostMapping("/guardarFinal")
	public String guardarFinales(@ModelAttribute("final") FinalModel f) {
		finalService.guardarFinal(modelMapper.map(f, Final.class));
		return "redirect:/notaPedido/finales";
	}

	@GetMapping("/eliminarFinal/{id}")
	public String eliminarFinalSeleccionado(@PathVariable("id") int id) {
		Final finalAux=finalService.getById(id);
		finalAux.setActivo(false);
		finalService.guardarFinal(finalAux);
		return "redirect:/notaPedido/finales";
	}
	
	

}
