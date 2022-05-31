package com.Grupo10OO22022.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Grupo10OO22022.entities.Espacio;
import com.Grupo10OO22022.helpers.EspacioFiltros;
import com.Grupo10OO22022.helpers.ViewRouteHelper;
import com.Grupo10OO22022.services.IEspacioService;

@Controller
@PreAuthorize("hasAuthority('administrador')")
@RequestMapping("/espacio")
public class EspacioController {
	
	
	@Autowired
	@Qualifier("espacioService")
	private IEspacioService espacioService;
	
	
	
	@GetMapping("/crear_espacios")
	public String crearEspacios() {
		return ViewRouteHelper.ESPACIO_CREAR_ESPACIO;
	}
	
	@GetMapping("/add")
	public ModelAndView agregarEspacios(@RequestParam(name="fecha_inicial", required=true, defaultValue="null") String sFechaInicial,
									@RequestParam(name="fecha_final", required=true, defaultValue="null") String sFechaFinal) {
		ModelAndView mv = new ModelAndView(ViewRouteHelper.ESPACIO_CREAR_ESPACIO);
		LocalDate fechaInicial = LocalDate.parse(sFechaInicial);
		LocalDate fechaFinal = LocalDate.parse(sFechaFinal);
		mv.addObject("espaciosAgregados", espacioService.agregarEspaciosParaTodasLasAulas(fechaInicial, fechaFinal));
		return mv;
	}
	
	@GetMapping("/ver_espacios")
	public ModelAndView verEspacios() {
		ModelAndView mv = new ModelAndView(ViewRouteHelper.ESPACIO_VER_ESPACIO);
		mv.addObject("espacios", espacioService.getAll());
		mv.addObject("filtros", new EspacioFiltros(null, null, true, true, true, true, true));
		return mv;
	}
	
	@PostMapping("/filtrarEspacios")
	public ModelAndView verEspaciosFiltrados(@ModelAttribute("filtros") EspacioFiltros filtros) {
		ModelAndView mv = new ModelAndView(ViewRouteHelper.ESPACIO_VER_ESPACIO);
		List<Espacio> lista = espacioService.traerPorFiltros(filtros);
		mv.addObject("espacios", lista);
		mv.addObject("filtros", filtros);
		return mv;
	}
	

}
