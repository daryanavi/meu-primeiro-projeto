/**
 * 31 de jan de 2019
 */
package com.daryan.api.security.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.daryan.api.security.JwtUserFactory;
import com.daryan.api.security.entities.Usuario;
import com.daryan.api.security.services.UsuarioService;

/**
 * @author Daryan Avi
 *
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		Optional<Usuario> funcionario = usuarioService.buscarPorEmail(username);

		if (funcionario.isPresent())
			return JwtUserFactory.create(funcionario.get());

		throw new UsernameNotFoundException("Email não encontrado.");
	}
}