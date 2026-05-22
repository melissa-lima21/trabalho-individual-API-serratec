package org.serratec.ongdeanimais.dto;

import org.serratec.ongdeanimais.domain.Endereco;

public class EnderecoDTOResponse {
	private Long id;
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String nomePessoa;

	public EnderecoDTOResponse() {
		super();
	}

	public EnderecoDTOResponse(Endereco endereco) {
		this.id = endereco.getId();
		this.rua = endereco.getRua();
		this.numero = endereco.getNumero();
		this.bairro = endereco.getBairro();
		this.cidade = endereco.getCidade();
		this.estado = endereco.getEstado();
		
		if (endereco.getPessoa() != null) {
			this.nomePessoa = endereco.getPessoa().getNome();
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

}
