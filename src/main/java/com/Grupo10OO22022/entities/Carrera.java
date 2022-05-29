package com.Grupo10OO22022.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "carrera")
public class Carrera {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "carrera")
	private String carrera;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_departamento", nullable=true)
	private Departamento departamento;

	public Carrera(String carrera, Departamento departamento) {
		this.carrera = carrera;
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "departamento=" + departamento;
	}
	
	
	
	
	
}
