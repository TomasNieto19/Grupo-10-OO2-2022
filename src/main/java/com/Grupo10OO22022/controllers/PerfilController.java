package com.Grupo10OO22022.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.Grupo10OO22022.helpers.ViewRouteHelper;
import com.Grupo10OO22022.services.IPerfilService;

@Controller
@PreAuthorize("hasAnyAuthority('administrador', 'auditoria')")
@RequestMapping("/perfiles")
public class PerfilController {

	@Autowired
	@Qualifier("perfilService")
	private IPerfilService perfilService;

	@GetMapping("/")
	public ModelAndView index() {

		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERFIL_INDEX);

		mAV.addObject("perfiles", perfilService.getAll());

		return mAV;
	}

}
