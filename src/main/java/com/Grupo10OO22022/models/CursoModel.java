package com.Grupo10OO22022.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import com.Grupo10OO22022.entities.Aula;
import com.Grupo10OO22022.entities.Fecha;
import com.Grupo10OO22022.entities.Materia;
import com.Grupo10OO22022.entities.Profesor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CursoModel extends NotaPedidoModel {

	private List<Fecha> fechas = new ArrayList<Fecha>();

	private String comision;

	public CursoModel(char turno, Aula aula, int cantEstudiantes, Materia materia, String observaciones,
			Set<Profesor> profesores, String comision) {
		super(turno, aula, cantEstudiantes, materia, observaciones, profesores);
		this.comision = comision;
	}

}
