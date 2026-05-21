package org.serratec.ongdeanimais.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "endereco")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O nome da rua é obrigatóriio.")
	@Column(nullable = false)
	private String rua;

	private String numero;
	
	@NotBlank(message = "O nome do bairro é obrigatório.")
	@Column(nullable = false)
	private String bairro;
	
	@NotBlank(message = "O nome da cidade é obrigatória.")
	@Size(max = 30)
	@Column(nullable = false, length = 30)
	private String cidade;
	
	@NotBlank(message = "O nome do estado é obrigatório.")
	@Size(max = 30)
	@Column(nullable = false, length = 30)
	private String estado;

	@OneToOne(mappedBy= "endereco")
	@JoinColumn
	private Pessoa pessoa;

	public Endereco() {
		super();
	}

	public Endereco(Long id, String rua, String numero, String bairro, String cidade, String estado, Pessoa pessoa) {
		super();
		this.id = id;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.pessoa = pessoa;
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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	


}
