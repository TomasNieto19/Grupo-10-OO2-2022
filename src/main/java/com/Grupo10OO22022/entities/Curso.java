package com.Grupo10OO22022.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
public class Curso extends NotaPedido {

	
	@ManyToMany(fetch = FetchType.LAZY)
	private Set<Fecha> fechas;
	
	@Column(name = "comision")
	private String comisión;
	
	
}
