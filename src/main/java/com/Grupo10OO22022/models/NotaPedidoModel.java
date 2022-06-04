package com.Grupo10OO22022.models;

import java.util.Set;


import com.Grupo10OO22022.entities.Aula;
import com.Grupo10OO22022.entities.Espacio;
import com.Grupo10OO22022.entities.Materia;
import com.Grupo10OO22022.entities.Profesor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor
public class NotaPedidoModel {

	
	protected int id;
	
	
	protected char turno;
	
	
	protected Aula aula;
	
	
	protected int cantEstudiantes;
	
	
	protected Materia materia;
	
	
	protected String observaciones;
	

	protected Set<Profesor> profesores;
	

	protected boolean pendiente;


	public NotaPedidoModel(char turno, Aula aula, int cantEstudiantes, Materia materia, String observaciones,
			Set<Profesor> profesores) {
		super();
		this.turno = turno;
		this.aula = aula;
		this.cantEstudiantes = cantEstudiantes;
		this.materia = materia;
		this.observaciones = observaciones;
		this.profesores = profesores;
		this.pendiente = true;
	}

	
	
	
}
