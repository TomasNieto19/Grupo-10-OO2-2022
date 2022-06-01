package com.Grupo10OO22022.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.Grupo10OO22022.entities.Final;

@Repository
public interface IFinalRepository extends JpaRepository<Final, Integer> {

	
	@Query("SELECT f FROM Final f JOIN f.profesores p JOIN f.materia m JOIN f.aula a JOIN a.edificio e WHERE f.activo = true and "
			+ "CONCAT (f.turno, f.cantEstudiantes, f.observaciones, f.mesa, f.fecha, " + "p.nombre, p.apellido, "
			+ "m.materia, m.codMateria, " + "a.numero, " + "e.edificio)" + " LIKE %?1%")
	public List<Final> search(String keyword);

	
	@Query("SELECT f FROM Final f JOIN f.materia m WHERE f.activo = (:activo) ORDER BY m.materia ASC")
	public List<Final> findAll(boolean activo);
}
