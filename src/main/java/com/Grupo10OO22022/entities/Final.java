package com.Grupo10OO22022.entities;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Final extends NotaPedido {

	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="id_fecha", nullable=true)
	private Fecha fecha;
	
	@Column(name = "mesa")
	private String mesa;

	
	@Override
	public String toString() {
		return "Final [fecha=" + fecha + ", mesa=" + mesa + "]";
	}


	public Final(String mesa, Fecha fecha) {
		this.mesa = mesa;
		this.fecha = fecha;
	}
	
	

	
	

	

	
	
	
	
	
	
}
