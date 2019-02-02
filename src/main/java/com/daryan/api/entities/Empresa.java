/**
 * 27 de jan de 2019
 */
package com.daryan.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

/**
 * @author Daryan Avi
 *
 */
@Entity
@Table(name = "empresa")
public class Empresa implements Serializable 
{
	private static final long serialVersionUID = 7326444125839094932L;

	private Long id;
	private String razaoSocial, cnpj;
	private Date dataCriacao, dataAtualizacao;
	private List<Funcionario> funcionarios;
	
	public Empresa() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId()
	{
		return id;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}
	
	@Column(name = "razao_social", nullable = false)
	public String getRazaoSocial()
	{
		return razaoSocial;
	}
	
	public void setRazaoSocial(String razaoSocial)
	{
		this.razaoSocial = razaoSocial;
	}
	
	@Column(name = "cnpj", nullable = false)
	public String getCnpj()
	{
		return cnpj;
	}
	
	public void setCnpj(String cnpj)
	{
		this.cnpj = cnpj;
	}
	
	@Column(name = "data_criacao", nullable = false)
	public Date getDataCriacao()
	{
		return dataCriacao;
	}
	
	public void setDataCriacao(Date dataCriacao)
	{
		this.dataCriacao = dataCriacao;
	}
	
	@Column(name = "data_atualizacao", nullable = false)
	public Date getDataAtualizacao()
	{
		return dataAtualizacao;
	}
	
	public void setDataAtualizacao(Date dataAtualizacao)
	{
		this.dataAtualizacao = dataAtualizacao;
	}
	
	@OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Funcionario> getFuncionarios()
	{
		return funcionarios;
	}
	
	public void setFuncionarios(List<Funcionario> funcionarios)
	{
		this.funcionarios = funcionarios;
	}
	
	@PreUpdate
	public void preUpdate()
	{
		dataAtualizacao = new Date();
	}
	
	@PrePersist
	public void prePersist()
	{
		Date data = new Date();
		
		dataCriacao = data;
		dataAtualizacao = data;
	}

	@Override
	public String toString()
	{
		return "Empresa [id=" + id + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", dataCriacao=" + dataCriacao
				+ ", dataAtualizacao=" + dataAtualizacao + "]";
	}
}