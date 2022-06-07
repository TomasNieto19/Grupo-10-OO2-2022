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

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "materia")
public class Materia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "materia")
	private String materia;

	@Column(name = "codigo")
	private String codMateria;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_carrera", nullable = true)
	private Carrera carrera;

	public Materia(String materia, Carrera carrera) {
		this.materia = materia;
		this.carrera = carrera;
	}

}
