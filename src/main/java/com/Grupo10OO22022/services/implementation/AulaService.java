package com.Grupo10OO22022.services.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.Grupo10OO22022.entities.Aula;
import com.Grupo10OO22022.repositories.IAulaRepository;
import com.Grupo10OO22022.services.IAulaService;

@Service
public class AulaService implements IAulaService {

	@Autowired
	@Qualifier("aulaRepository")
	private IAulaRepository aulaRepository;

	@Override
	public List<Aula> getAll() {
		return aulaRepository.findAll();
	}

}
