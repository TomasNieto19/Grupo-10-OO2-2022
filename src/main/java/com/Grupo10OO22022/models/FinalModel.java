package com.Grupo10OO22022.models;

import java.util.Set;

import com.Grupo10OO22022.entities.Aula;
import com.Grupo10OO22022.entities.Fecha;
import com.Grupo10OO22022.entities.Materia;
import com.Grupo10OO22022.entities.Profesor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor
public class FinalModel extends NotaPedidoModel{

	private Fecha fecha;
	
	private String mesa;

	public FinalModel(char turno, Aula aula, int cantEstudiantes, Materia materia, String observaciones,
			Set<Profesor> profesores, Fecha fecha, String mesa) {
		super(turno, aula, cantEstudiantes, materia, observaciones, profesores);
		this.fecha = fecha;
		this.mesa = mesa;
	}
	
	
	
}
