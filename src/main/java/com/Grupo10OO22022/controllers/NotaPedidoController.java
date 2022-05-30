package com.Grupo10OO22022.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Grupo10OO22022.entities.Curso;
import com.Grupo10OO22022.entities.Final;
import com.Grupo10OO22022.helpers.ViewRouteHelper;
import com.Grupo10OO22022.services.ICursoService;
import com.Grupo10OO22022.services.IFinalService;


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
		return mv;
	}
	
	
	
}