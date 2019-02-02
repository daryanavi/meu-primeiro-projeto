package com.daryan.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import com.daryan.api.documents.Cliente;
import com.daryan.api.repository.ClienteRepository;
import com.daryan.api.security.entities.Usuario;
import com.daryan.api.security.enums.PerfilEnum;
import com.daryan.api.security.repositories.UsuarioRepository;
import com.daryan.api.services.ExemploCacheService;
import com.daryan.api.utils.SenhaUtils;

@SpringBootApplication()
@EnableCaching
public class MeuPrimeiroProjetoApplication 
{
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ExemploCacheService exemploCacheService;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public static void main(String[] args) 
	{
		SpringApplication.run(MeuPrimeiroProjetoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner()
	{
		return args ->
		{
			/*
			 * Get/Post
			 */
			Usuario usuario = new Usuario();
			usuario.setEmail("usuario@email.com");
			usuario.setPerfil(PerfilEnum.ROLE_USUARIO);
			usuario.setSenha(SenhaUtils.gerarBCrypt("123456"));
			this.usuarioRepository.save(usuario);
			
			Usuario admin = new Usuario();
			admin.setEmail("admin@email.com");
			admin.setPerfil(PerfilEnum.ROLE_ADMIN);
			admin.setSenha(SenhaUtils.gerarBCrypt("123456"));
			this.usuarioRepository.save(admin);
			
			/*
			 * Cache
			 */
			System.out.println("Executando serviço pela primeira vez: ");
			System.out.println(exemploCacheService.exemploCache());
			
			System.out.println("Executando serviço pela segunda vez, deve obter dados do cache: ");
			System.out.println(exemploCacheService.exemploCache());
			
			/*
			 * MongoDB
			 */
			clienteRepository.deleteAll();
			
			clienteRepository.save(new Cliente("Alice", 20));
			clienteRepository.save(new Cliente("João", 30));
			clienteRepository.save(new Cliente("Maria", 40));
			
			System.out.println("Lista todos com o findAll():");
			System.out.println("----------------------------");
			clienteRepository.findAll().forEach(System.out::println);
			System.out.println();
			
			System.out.println("Busca um único cliente com o findByNome('Alice'):");
			System.out.println("----------------------------");
			clienteRepository.findByNome("Alice");
			System.out.println();
			
			System.out.println("Clientes com idade entre 18 e 35:");
			System.out.println("----------------------------");
			clienteRepository.findByIdadeBetween(18, 35).forEach(System.out::println);
		};
	}
}