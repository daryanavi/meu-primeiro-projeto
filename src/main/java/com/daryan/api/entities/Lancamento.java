/**
 * 27 de jan de 2019
 */
package com.daryan.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.daryan.api.enums.TipoEnum;

/**
 * @author Daryan Avi
 *
 */
@Entity
@Table(name = "lancamento")
public class Lancamento implements Serializable
{
	private static final long serialVersionUID = -8835257031071124210L;
	
	private Long id;
	private Date data, dataCriacao, dataAtualizacao;
	private String descricao, localizacao;
	private TipoEnum tipo;
	private Funcionario funcionario;
	
	public Lancamento() {}

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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data", nullable = false)
	public Date getData()
	{
		return data;
	}

	public void setData(Date data)
	{
		this.data = data;
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

	@Column(name = "descricao", nullable = true)
	public String getDescricao()
	{
		return descricao;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}

	@Column(name = "localizacao", nullable = true)
	public String getLocalizacao()
	{
		return localizacao;
	}

	public void setLocalizacao(String localizacao)
	{
		this.localizacao = localizacao;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", nullable = false)
	public TipoEnum getTipo()
	{
		return tipo;
	}

	public void setTipo(TipoEnum tipo)
	{
		this.tipo = tipo;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	public Funcionario getFuncionario()
	{
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario)
	{
		this.funcionario = funcionario;
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
		return "Lancamento [id=" + id + ", data=" + data + ", dataCriacao=" + dataCriacao + ", dataAtualizacao="
				+ dataAtualizacao + ", descricao=" + descricao + ", localizacao=" + localizacao + ", tipo=" + tipo
				+ ", funcionario=" + funcionario + "]";
	}
}