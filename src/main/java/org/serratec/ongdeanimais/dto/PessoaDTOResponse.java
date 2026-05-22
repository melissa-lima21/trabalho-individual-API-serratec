package org.serratec.ongdeanimais.dto;

import java.util.ArrayList;
import java.util.List;

import org.serratec.ongdeanimais.domain.Animal;
import org.serratec.ongdeanimais.domain.Pessoa;

public class PessoaDTOResponse {
	private Long id;
	private String nome;
	private String email;
	private String enderecoCompleto;
	private List<String> nomeAnimais;

	public PessoaDTOResponse() {
		super();
	}

	public PessoaDTOResponse(Pessoa pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.email = pessoa.getEmail();

		if (pessoa.getEndereco() != null) {
			this.enderecoCompleto = pessoa.getEndereco().getRua() + ", " + pessoa.getEndereco().getNumero();
		}

		this.nomeAnimais = new ArrayList<>();
		if (pessoa.getAnimais() != null) {
			for (Animal animal : pessoa.getAnimais()) {
				this.nomeAnimais.add(animal.getNome());
			}
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEnderecoCompleto() {
		return enderecoCompleto;
	}

	public void setEnderecoCompleto(String enderecoCompleto) {
		this.enderecoCompleto = enderecoCompleto;
	}

	public List<String> getNomeAnimais() {
		return nomeAnimais;
	}

	public void setNomeAnimais(List<String> nomeAnimais) {
		this.nomeAnimais = nomeAnimais;
	}

}
