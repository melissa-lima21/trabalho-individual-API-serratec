package org.serratec.ongdeanimais.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class EnderecoDTORequest {

	@NotBlank(message = "Preencha o nome da rua.")
	private String rua;

	private String numero;

	@NotBlank(message = "Preencha o nome do bairro.")
	private String bairro;

	@NotBlank(message = "Preencha o nome da cidade.")
	@Size(max = 30, message = "A cidade deve ter no máximo 30 caracteres.")
	private String cidade;

	@NotBlank(message = "Preencha o nome do estado.")
	@Size(max = 30, message = "O estado deve ter no máximo 30 caracteres.")
	private String estado;

	public EnderecoDTORequest() {
		super();
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

}
