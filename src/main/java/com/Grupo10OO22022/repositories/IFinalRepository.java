package com.Grupo10OO22022.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.Grupo10OO22022.entities.Final;


@Repository
public interface IFinalRepository extends JpaRepository<Final, Integer>{

	
     @Query("SELECT f FROM Final f JOIN f.profesores p JOIN f.materia m JOIN f.aula a JOIN a.edificio e WHERE "
    		+ "CONCAT (f.turno, f.cantEstudiantes, f.observaciones, f.mesa, "
    		+ "p.nombre, p.apellido, "
    		+ "m.materia, m.codMateria, "
    		+ "a.numero, "
    		+ "e.edificio)"
    		+ " LIKE %?1%")
    public List<Final> search(String keyword);

}
/*
	 ¡¡ REVISAR !!
	protected boolean pendiente;
	
	protected boolean activo;

	-----PROPIOS DE FINAL-----

	private LocalDate fecha;
	

*/