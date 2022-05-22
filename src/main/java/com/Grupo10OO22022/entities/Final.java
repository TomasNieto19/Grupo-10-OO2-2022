package com.Grupo10OO22022.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
//@PrimaryKeyJoinColumn(referencedColumnName = "final_pedido")
public class Final extends NotaPedido {

	
	@Column(name = "fecha")
	private LocalDate fecha;
	
	@Column(name = "mesa")
	private String mesa;

	
	
	
	
	
	
}
