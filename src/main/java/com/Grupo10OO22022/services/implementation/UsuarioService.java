package com.Grupo10OO22022.services.implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Grupo10OO22022.entities.Perfil;
import com.Grupo10OO22022.entities.Usuario;
import com.Grupo10OO22022.repositories.IUsuarioRepository;

@Service("usuarioService")
public class UsuarioService implements UserDetailsService {

	@Autowired
	@Qualifier("usuarioRepository")
	private IUsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByUsernameWithPerfil(username);
		return builUser(usuario, buildGrantedAuthorities(usuario.getPerfil()));
	}

	private User builUser(Usuario usuario, List<GrantedAuthority> grantedAuthorities) {
		return new User(usuario.getNombreUsuario(), usuario.getClave(), grantedAuthorities);
	}

	private List<GrantedAuthority> buildGrantedAuthorities(Perfil perfil) {
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		grantedAuthorities.add(new SimpleGrantedAuthority(perfil.getTipoPerfil()));
		return new ArrayList<GrantedAuthority>(grantedAuthorities);
	}

}
