package com.Grupo10OO22022.models;

import java.time.LocalDate;
import java.util.Set;

import com.Grupo10OO22022.entities.Aula;
import com.Grupo10OO22022.entities.Espacio;
import com.Grupo10OO22022.entities.Materia;
import com.Grupo10OO22022.entities.Profesor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor
public class FinalModel extends NotaPedidoModel{

	private LocalDate fecha;
	
	private String mesa;

	public FinalModel(char turno, Aula aula, int cantEstudiantes, Materia materia, String observaciones,
			Set<Espacio> espaciosAsignados, Set<Profesor> profesores, boolean pendiente, LocalDate fecha, String mesa) {
		super(turno, aula, cantEstudiantes, materia, observaciones, espaciosAsignados, profesores, pendiente);
		this.fecha = fecha;
		this.mesa = mesa;
	}
	
	
	
}
