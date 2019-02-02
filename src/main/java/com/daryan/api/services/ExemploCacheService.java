/**
 * 2 de fev de 2019
 */
package com.daryan.api.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author Daryan Avi
 *
 */
@Service
public class ExemploCacheService
{
	private static final Logger log = LoggerFactory.getLogger(ExemploCacheService.class);
	
	@Cacheable("exemploCache")
	public String exemploCache()
	{
		log.info("### Executando o serviço...");
		
		return "Texto de exemplo do cache";
	}
}