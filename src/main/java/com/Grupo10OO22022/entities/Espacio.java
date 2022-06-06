package com.Grupo10OO22022.entities;

import java.time.LocalDate;

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
@Table(name = "espacio")
public class Espacio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "fecha")
	private LocalDate fecha;
	
	@Column(name = "turno")
	private char turno;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_aula", nullable=false)
	private Aula aula;
	
	@Column(name = "libre")
	private boolean libre;

	public Espacio(LocalDate fecha, char turno, Aula aula, boolean libre) {
		this.fecha = fecha;
		this.turno = turno;
		this.aula = aula;
		this.libre = libre;
	}
}
