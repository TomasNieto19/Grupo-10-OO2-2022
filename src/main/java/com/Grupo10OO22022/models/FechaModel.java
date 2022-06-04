package com.Grupo10OO22022.models;

import java.time.LocalDate;

import com.Grupo10OO22022.entities.Espacio;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class FechaModel {
	
	private int id;
	private LocalDate fecha;
	private Espacio espacioAsignado;
	public FechaModel(LocalDate fecha, Espacio espacioAsignado) {
		super();
		this.fecha = fecha;
		this.espacioAsignado = espacioAsignado;
	}
	@Override
	public String toString() {
		return "fecha " + fecha;
	}
	
	
	
}
