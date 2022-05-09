package com.Grupo10OO22022.services;

import java.util.List;

import com.Grupo10OO22022.entities.Usuario;

public interface IUsuarioService {

	public List<Usuario> traerUsuarios();

	public Usuario traerId(int id);

	public Usuario traerNombreUsuario(String username);

	public Usuario insertOrUpdate(Usuario user);

	public boolean remove(int id);

}
