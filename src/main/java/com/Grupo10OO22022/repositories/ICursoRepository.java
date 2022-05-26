package com.Grupo10OO22022.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Grupo10OO22022.entities.Curso;

@Repository("cursoRepository")
public interface ICursoRepository extends JpaRepository<Curso, Integer>{

	
	
}
