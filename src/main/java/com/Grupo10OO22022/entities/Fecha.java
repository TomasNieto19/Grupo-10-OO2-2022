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

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "fecha")
public class Fecha {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "fecha")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate fecha;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_espacio", nullable=true)
	private Espacio espacioAsignado;

	public Fecha(LocalDate fecha, Espacio espacioAsignado) {
		this.fecha = fecha;
		this.espacioAsignado = espacioAsignado;
	}
	
	
	
}
