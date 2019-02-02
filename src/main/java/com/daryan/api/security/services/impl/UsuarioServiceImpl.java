/**
 * 31 de jan de 2019
 */
package com.daryan.api.security.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daryan.api.security.entities.Usuario;
import com.daryan.api.security.repositories.UsuarioRepository;
import com.daryan.api.security.services.UsuarioService;

/**
 * @author Daryan Avi
 *
 */
@Service
public class UsuarioServiceImpl implements UsuarioService 
{
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Optional<Usuario> buscarPorEmail(String email)
	{
		return Optional.ofNullable(this.usuarioRepository.findByEmail(email));
	}
}