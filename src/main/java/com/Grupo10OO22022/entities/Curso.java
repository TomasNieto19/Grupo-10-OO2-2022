package com.Grupo10OO22022.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
//@PrimaryKeyJoinColumn(referencedColumnName = "curso_pedido")
public class Curso extends NotaPedido {
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL )
	@OrderBy("fecha ASC")
	private Set<Fecha> fechas;
	
	@Column(name = "comision")
	private String comision;
	
}