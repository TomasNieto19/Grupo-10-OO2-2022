package com.Grupo10OO22022.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Aula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	
	@Column(name = "numero")
	protected int numero;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_edificio", nullable=false)
	protected Edificio edificio;

	public Aula(int numero, Edificio edificio) {
		this.numero = numero;
		this.edificio = edificio;
	}

}
