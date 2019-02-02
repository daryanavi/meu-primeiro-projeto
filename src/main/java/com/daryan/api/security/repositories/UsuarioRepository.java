/**
 * 31 de jan de 2019
 */
package com.daryan.api.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.daryan.api.security.entities.Usuario;

/**
 * @author Daryan Avi
 *
 */
@Transactional(readOnly = true)
public interface UsuarioRepository extends JpaRepository<Usuario, Long> 
{
	Usuario findByEmail(String email);
}