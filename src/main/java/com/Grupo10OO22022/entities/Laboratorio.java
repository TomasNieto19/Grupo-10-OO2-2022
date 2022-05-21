package com.Grupo10OO22022.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
public class Laboratorio extends Aula{

	@Column(name = "cantPC")
	private int cantPC;
	
	@Column(name = "cantSillas")
	private int cantSillas;
}
