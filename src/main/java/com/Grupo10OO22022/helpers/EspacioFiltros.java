package com.Grupo10OO22022.helpers;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class EspacioFiltros {
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaInicial;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaFinal;
	private boolean libre;
	private boolean ocupado;
	private boolean maniana;
	private boolean tarde;
	private boolean noche;
	
	
	public EspacioFiltros(LocalDate fechaInicial, LocalDate fechaFinal, boolean libre, boolean ocupado, boolean maniana,
			boolean tarde, boolean noche) {
		super();
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
		this.libre = libre;
		this.ocupado = ocupado;
		this.maniana = maniana;
		this.tarde = tarde;
		this.noche = noche;
	}
	
	

}
