package com.Grupo10OO22022.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.Grupo10OO22022.entities.Curso;


@Repository("cursoRepository")
public interface ICursoRepository extends JpaRepository<Curso, Integer>{

    @Query("SELECT c FROM Curso c JOIN c.profesores p JOIN c.materia m JOIN c.aula a JOIN a.edificio e WHERE "
     		+ "CONCAT (c.turno, c.cantEstudiantes, c.observaciones, c.comision, "
    		+ "p.nombre, p.apellido, "
    		+ "m.materia, m.codMateria, "
    		+ "a.numero, "
    		+ "e.edificio) "
    		+ "LIKE %?1%")
    public List<Curso> search(String keyword);

}
/*
		 ¡¡ REVISAR !!
	private Set<Fecha> fechas;
	protected char turno;
	protected boolean pendiente;
	protected boolean activo;
	
*/