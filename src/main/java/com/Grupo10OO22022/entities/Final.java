package com.Grupo10OO22022.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
public class Final extends NotaPedido {

	
	@Column(name = "fecha")
	private LocalDate fecha;
	
	@Column(name = "mesa")
	private String mesa;
	
	
}
