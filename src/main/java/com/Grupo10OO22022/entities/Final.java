package com.Grupo10OO22022.entities;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Final extends NotaPedido {

	
	@Column(name = "fecha")
	private LocalDate fecha;
	
	@Column(name = "mesa")
	private String mesa;

	
	@Override
	public String toString() {
		return "Final [fecha=" + fecha + ", mesa=" + mesa + "]";
	}


	public Final(LocalDate fecha, String mesa) {
		super();
		this.fecha = fecha;
		this.mesa = mesa;
	}
	
	

	
	

	

	
	
	
	
	
	
}
