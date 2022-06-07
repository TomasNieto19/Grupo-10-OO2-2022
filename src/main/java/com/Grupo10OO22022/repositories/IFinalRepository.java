package com.Grupo10OO22022.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.Grupo10OO22022.entities.Final;

@Repository
public interface IFinalRepository extends JpaRepository<Final, Integer> {

	// Filtra por palabra clave todos estos campos
	@Query("SELECT f FROM Final f JOIN f.profesores p JOIN f.materia m JOIN f.aula a JOIN a.edificio e WHERE f.activo = true and "
			+ "CONCAT (f.turno, f.cantEstudiantes, f.observaciones, f.mesa, f.fecha, " + "p.nombre, p.apellido, "
			+ "m.materia, m.codMateria, " + "a.numero, " + "e.edificio)" + " LIKE %?1%")
	public List<Final> search(String keyword);

	// Filtra las notas de pedido activas en el sistema
	@Query("SELECT f FROM Final f JOIN f.materia m WHERE f.activo = (:activo)")
	public List<Final> findAll(boolean activo);

	// Filtra las notas de pedido activas en el sistema y si están pendientes a
	// asignarle espacios o no
	@Query("SELECT f FROM Final f WHERE f.activo = (:activo) AND f.pendiente = (:pendiente)")
	public List<Final> findAll(boolean activo, boolean pendiente);

}
