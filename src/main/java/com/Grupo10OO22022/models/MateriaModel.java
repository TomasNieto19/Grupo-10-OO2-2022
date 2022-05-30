package com.Grupo10OO22022.models;

import com.Grupo10OO22022.entities.Carrera;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class MateriaModel {
	private int id;
	private String codMateria;
	private String materia;
	private Carrera carrera;
	
	@Override
	public String toString() {
		return "carrera " + carrera;
	}
	
	
	
	
}
