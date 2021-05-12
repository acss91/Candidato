package com.candidatos.candidatos.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cartoes")
public class CartaoCredito {
	private long id;
	private String nomePortador;
	private long numero;
	private String dataVenc;
	private String codValidade;

	private Candidato inscritos;

	public CartaoCredito() {

	}

	public CartaoCredito(long id, String nomePortador, long numero, String dataVenc, String codValidade,
			Candidato inscritos) {

		this.id = id;
		this.numero = numero;
		this.dataVenc = dataVenc;
		this.codValidade = codValidade;
		this.inscritos = inscritos;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomePortador() {
		return nomePortador;
	}

	public void setNomePortador(String nomePortador) {
		this.nomePortador = nomePortador;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public String getDataVenc() {
		return dataVenc;
	}

	public void setDataVenc(String dataVenc) {
		this.dataVenc = dataVenc;
	}

	public String getCodValidade() {
		return codValidade;
	}

	public void setCodValidade(String codValidade) {
		this.codValidade = codValidade;
	}

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "inscritos_id")
	public Candidato getInscritos() {
		return inscritos;
	}

	public void setInscritos(Candidato inscritos) {
		this.inscritos = inscritos;
	}

}
