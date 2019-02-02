/**
 * 30 de jan de 2019
 */
package com.daryan.api.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daryan.api.dtos.EmpresaDTO;
import com.daryan.api.responses.Response;

/**
 * @author Daryan Avi
 *
 */
@RestController
@RequestMapping("/api/empresas")
public class EmpresaController
{
	@PostMapping
	public ResponseEntity<Response<EmpresaDTO>> cadastrar(@Valid @RequestBody EmpresaDTO empresaDTO,
			BindingResult result)
	{
		Response<EmpresaDTO> response = new Response<>();
		
		if (result.hasErrors())
		{
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			
			return ResponseEntity.badRequest().body(response);
		}
		
		empresaDTO.setId(1L);
		response.setData(empresaDTO);
		
		return ResponseEntity.ok(response);
	}
}