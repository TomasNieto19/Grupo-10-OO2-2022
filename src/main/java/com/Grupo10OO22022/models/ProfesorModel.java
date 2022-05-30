package com.Grupo10OO22022.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ProfesorModel {

	private int id;
	private String apellido;
	private String nombre;
	public ProfesorModel(String apellido, String nombre) {
		super();
		this.apellido = apellido;
		this.nombre = nombre;
	}
	

	
	
	
	
	
}
