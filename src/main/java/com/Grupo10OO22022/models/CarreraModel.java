package com.Grupo10OO22022.models;

import com.Grupo10OO22022.entities.Departamento;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class CarreraModel {
	private int id;
	private String carrera;
	private Departamento departamento;
	@Override
	public String toString() {
		return "departamento " + departamento ;
	}
	
}
