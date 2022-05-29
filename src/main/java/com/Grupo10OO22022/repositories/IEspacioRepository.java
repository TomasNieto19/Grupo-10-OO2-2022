package com.Grupo10OO22022.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Grupo10OO22022.entities.Espacio;

@Repository("espacioRepository")
public interface IEspacioRepository extends JpaRepository<Espacio, Integer>{

	public List<Espacio> findByFechaBetween(LocalDate fechaIncial, LocalDate fechaFinal);
	
}
