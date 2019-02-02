/**
 * 2 de fev de 2019
 */
package com.daryan.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.daryan.api.documents.Cliente;

/**
 * @author Daryan Avi
 *
 */
public interface ClienteRepository extends MongoRepository<Cliente, String>
{
	Cliente findByNome(String nome);
	
	@Query("{ 'idade' : { $gt: ?0, $lt: ?1 } }")
	List<Cliente> findByIdadeBetween(int idadeInicial, int idadeFinal);
}