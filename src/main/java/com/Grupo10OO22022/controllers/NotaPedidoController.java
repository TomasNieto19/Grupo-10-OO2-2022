package com.Grupo10OO22022.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.Grupo10OO22022.helpers.ViewRouteHelper;
import com.Grupo10OO22022.services.ICursoService;



@Controller
@PreAuthorize("hasAnyAuthority('administrador', 'auditoria')")
@RequestMapping("/notaPedido")
public class NotaPedidoController {
	
	
	@Autowired
	@Qualifier("cursoService")
	private ICursoService cursoService;
	
	
	@GetMapping("/cursadas")
	public ModelAndView cursadas() {
		
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.NOTA_PEDIDO_CURSADAS);
		
		mAV.addObject("cursadas", cursoService.getAll() );
		
		return mAV;
	}
	
	
	@GetMapping("/finales")
	public ModelAndView finales() {
		
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.NOTA_PEDIDO_FINALES);
		
		//mAV.addObject("finales", perfilService.getAll() );
		
		return mAV;
	}

	
}