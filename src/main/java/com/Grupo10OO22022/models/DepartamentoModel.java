package com.Grupo10OO22022.models;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class DepartamentoModel {
	
	private int id;
	private String departamento;
	
	public DepartamentoModel(int id, String departamento) {
		super();
		this.id = id;
		this.departamento = departamento;
	}
	
	public DepartamentoModel(String departamento) {
		super();
		this.departamento = departamento;
	}

	
	@Override
	public String toString() {
		return "DepartamentoModel [departamento=" + departamento + "]";
	}

	public DepartamentoModel(int id) {
		super();
		this.id = id;
	}
	
	
}
