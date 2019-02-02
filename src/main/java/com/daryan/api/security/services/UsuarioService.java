/**
 * 31 de jan de 2019
 */
package com.daryan.api.security.services;

import java.util.Optional;

import com.daryan.api.security.entities.Usuario;

/**
 * @author Daryan Avi
 *
 */
public interface UsuarioService 
{
	/**
	 * Busca e retorna um usuário dado um email.
	 * 
	 * @param email
	 * @return Optional<Usuario>
	 */
	Optional<Usuario> buscarPorEmail(String email);
}