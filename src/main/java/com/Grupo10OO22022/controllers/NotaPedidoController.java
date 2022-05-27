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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
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
	public ModelAndView cursadas() {
		
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.NOTA_PEDIDO_CURSADAS);
		
		mAV.addObject("cursadas", cursoService.getAll() );
		
		return mAV;
	}


	@GetMapping("/finales")
	public String listarFinales(Model model, @Param("keyword") String keyword) {
		
		//Esta consulta puede devolver objetos repetidos.
		List<Final> finalesRepetidos = this.finalService.listAll(keyword);
		
		//Lista sin objetos repetidos para devolver a la vista.
		List<Final> finales = new ArrayList<Final>();
		
		//Si el objeto ya está, no lo vuelve agregar.
		for (Final element : finalesRepetidos) {
			
	          if (!finales.contains(element)) {
	        	  
	            finales.add(element);
	            
	          }
	    }
		
		model.addAttribute("finales", finales);
		
		model.addAttribute("keyword", keyword);
		
		return ViewRouteHelper.FINAL_VER_FINALES;
	}
	
}