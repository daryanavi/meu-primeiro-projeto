/**
 * 31 de jan de 2019
 */
package com.daryan.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Daryan Avi
 *
 */
@RestController
@RequestMapping("/api")
public class VersionamentoApiController
{
	@GetMapping(value = "/v1/ola/{nome}")
	public ResponseEntity<String> olaNomeV1(@PathVariable("nome") String nome)
	{
		return ResponseEntity.ok(String.format("API v1: Olá %s!", nome));
	}
	
	@GetMapping(value = "/v2/ola/{nome}")
	public ResponseEntity<String> olaNomeV2(@PathVariable("nome") String nome)
	{
		return ResponseEntity.ok(String.format("API v2: Olá %s!", nome));
	}
	
	@GetMapping(value = "/ola/{nome}", headers = "X-API-Version=1")
	public ResponseEntity<String> olaNomeHeaderV1(@PathVariable("nome") String nome)
	{
		return ResponseEntity.ok(String.format("API v1: Olá %s!", nome));
	}
	
	@GetMapping(value = "/ola/{nome}", headers = "X-API-Version=2")
	public ResponseEntity<String> olaNomeHeaderV2(@PathVariable("nome") String nome)
	{
		return ResponseEntity.ok(String.format("API v2: Olá %s!", nome));
	}
}