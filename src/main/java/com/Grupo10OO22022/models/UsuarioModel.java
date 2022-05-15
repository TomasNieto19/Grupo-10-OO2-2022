package com.Grupo10OO22022.models;

import com.Grupo10OO22022.entities.Perfil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class UsuarioModel {


	private int idUsuario;
	
	private String nombre;
	
	private String apellido;
	
	private long dni;
	
	private String email;
	
	private String nombreUsuario;
	
	private Perfil perfil;
	
}
