package com.Grupo10OO22022.services.implementation;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.Grupo10OO22022.entities.Perfil;
import com.Grupo10OO22022.models.PerfilModel;
import com.Grupo10OO22022.repositories.IPerfilRepository;
import com.Grupo10OO22022.services.IPerfilService;

@Service("perfilService")
public class PerfilService implements IPerfilService{

	@Autowired
	@Qualifier("perfilRepository")
	private IPerfilRepository perfilRepository;
	
	
	private ModelMapper modelMapper = new ModelMapper();
	
	
	
	@Override
	public List<Perfil> getAll() {

		return this.perfilRepository.findAll();
	}

	
	@Override
	public PerfilModel insertOrUpdate(PerfilModel perfilModel) {
		
		Perfil perfil = this.perfilRepository.save( modelMapper.map(perfilModel, Perfil.class) );

		return modelMapper.map(perfil, PerfilModel.class);
	}

	
	
}
