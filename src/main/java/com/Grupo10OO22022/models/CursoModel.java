package com.Grupo10OO22022.models;

import java.util.Set;

import com.Grupo10OO22022.entities.Aula;
import com.Grupo10OO22022.entities.Espacio;
import com.Grupo10OO22022.entities.Fecha;
import com.Grupo10OO22022.entities.Materia;
import com.Grupo10OO22022.entities.Profesor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor
public class CursoModel extends NotaPedidoModel {

	private Set<Fecha> fechas;
	
	private String comision;

	public CursoModel(char turno, Aula aula, int cantEstudiantes, Materia materia, String observaciones,
			Set<Espacio> espaciosAsignados, Set<Profesor> profesores, boolean pendiente, Set<Fecha> fechas,
			String comision) {
		super(turno, aula, cantEstudiantes, materia, observaciones, espaciosAsignados, profesores, pendiente);
		this.fechas = fechas;
		this.comision = comision;
	}

	
	
	
	
}
