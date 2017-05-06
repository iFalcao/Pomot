package com.pomot.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
@Table (name = "pomo_tempo")
public class PomoTempo {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name = "nome_pomo", nullable = false, length = 30)
	private String nomePomo;
	
	@Column (name = "descricao_pomo")
	private String descricaoPomo;
	
	@Column (name = "tempo_pomo", nullable = false)
	private Byte tempoPomo;
	
	@Temporal (TemporalType.TIMESTAMP)
	@Column (name = "data_criacao", nullable = false)
	private Date dataCriacao;
	
	@ManyToOne
	@JoinColumn (name = "usuario_id")
	private Usuario usuario;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomePomo() {
		return nomePomo;
	}

	public void setNomePomo(String nomePomo) {
		this.nomePomo = nomePomo;
	}

	public String getDescricaoPomo() {
		return descricaoPomo;
	}

	public void setDescricaoPomo(String descricaoPomo) {
		this.descricaoPomo = descricaoPomo;
	}

	public Byte getTempoPomo() {
		return tempoPomo;
	}

	public void setTempoPomo(Byte tempoPomo) {
		this.tempoPomo = tempoPomo;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
