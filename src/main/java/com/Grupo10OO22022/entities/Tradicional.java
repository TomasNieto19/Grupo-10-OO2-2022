package com.Grupo10OO22022.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
public class Tradicional extends Aula{

	
	@Column(name = "cantBancos")
	private  int cantBancos;
	
	@Column(name = "pizarron")
	private String pizarron;
	
	@Column(name = "tieneProyector")
	private boolean tieneProyector;

	public Tradicional(int numero, Edificio edificio, int cantBancos, String pizarron, boolean tieneProyector) {
		super(numero, edificio);
		this.cantBancos = cantBancos;
		this.pizarron = pizarron;
		this.tieneProyector = tieneProyector;
	}
	
	
	
}
