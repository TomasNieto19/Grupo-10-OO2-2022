package com.Grupo10OO22022.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Grupo10OO22022.entities.Usuario;

@Repository("usuarioRepository")
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

	public abstract Usuario findById(int id);

	@Query("SELECT u FROM Usuario u inner join fetch u.perfil where u.nombreUsuario = (:username)")
	public abstract Usuario findByUsernameWithPerfil(@Param("username") String username);

}
