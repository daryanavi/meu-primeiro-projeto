/**
 * 30 de jan de 2019
 */
package com.daryan.api.dtos;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

/**
 * @author Daryan Avi
 *
 */
public class EmpresaDTO
{
	private Long id;
	private String razaoSocial, cnpj;
	
	public Long getId()
	{
		return id;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}
	
	@NotEmpty(message = "Razão social não pode ser vazia")
	@Length(min = 5, max = 200, message = "Razão social deve conter entre 5 e 200 caracteres")
	public String getRazaoSocial()
	{
		return razaoSocial;
	}
	
	public void setRazaoSocial(String razaoSocial)
	{
		this.razaoSocial = razaoSocial;
	}
	
	@NotEmpty(message = "CNPJ não pode ser vazio")
	@CNPJ(message = "CNPJ inválido")
	public String getCnpj()
	{
		return cnpj;
	}
	
	public void setCnpj(String cnpj)
	{
		this.cnpj = cnpj;
	}

	@Override
	public String toString()
	{
		return "EmpresaDTO [id=" + id + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + "]";
	}
}