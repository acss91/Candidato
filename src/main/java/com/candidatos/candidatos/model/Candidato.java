package com.candidatos.candidatos.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "candidatos")
public class Candidato {
	private long id;
	private String nome;
	private String vaga;
	private String endereco;
	private String telefone;
	private long documento;
	private List<CartaoCredito> cartoes = new ArrayList<CartaoCredito>();

	public Candidato() {
		
	}

	public Candidato(long id, String nome, String vaga, String endereco, String telefone, long documento,
			List<CartaoCredito> cartoes) {

		this.id = id;
		this.nome = nome;
		this.vaga = vaga;
		this.endereco = endereco;
		this.telefone = telefone;
		this.documento = documento;
		this.cartoes = cartoes;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getVaga() {
		return vaga;
	}

	public void setVaga(String vaga) {
		this.vaga = vaga;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public long getDocumento() {
		return documento;
	}

	public void setDocumento(long documento) {
		this.documento = documento;
	}
	@OneToMany( mappedBy = "inscritos")
	public List<CartaoCredito> getCartoes() {
		return cartoes;
	}

	public void setCartoes(List<CartaoCredito> cartoes) {
		this.cartoes = cartoes;
	}

}
