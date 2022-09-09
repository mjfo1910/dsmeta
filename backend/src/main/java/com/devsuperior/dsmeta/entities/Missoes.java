package com.devsuperior.dsmeta.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_missoes")
public class Missoes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate date;
	private String nomeOfertante;
	private String localMissao;
	private Double contribuicao;
	private Double total;
	
	
	public Missoes() {//Metodos de acesso
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getNomeOfertante() {
		return nomeOfertante;
	}

	public void setNomeOfertante(String nomeOfertante) {
		this.nomeOfertante = nomeOfertante;
	}

	public String getLocalMissao() {
		return localMissao;
	}

	public void setLocalMissao(String localMissao) {
		this.localMissao = localMissao;
	}

	public Double getContribuicao() {
		return contribuicao;
	}

	public void setContribuicao(Double contribuicao) {
		this.contribuicao = contribuicao;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
}
