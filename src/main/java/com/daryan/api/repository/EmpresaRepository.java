/**
 * 29 de jan de 2019
 */
package com.daryan.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daryan.api.entities.Empresa;

/**
 * @author Daryan Avi
 *
 */
public interface EmpresaRepository extends JpaRepository<Empresa, Long>
{
	Empresa findByCnpj(String cnpj);
}