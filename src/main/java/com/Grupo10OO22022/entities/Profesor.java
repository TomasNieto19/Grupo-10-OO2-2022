package com.Grupo10OO22022.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "profesor")
public class Profesor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	@Column(name = "nombre")
	public String nombre;
	
	@Column(name = "apellido")
	public String apellido;

	public Profesor(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}

}
