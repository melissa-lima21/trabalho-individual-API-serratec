package org.serratec.ongdeanimais.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "pessoa")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O nome é obrigatório.")
	@Size(max = 70)
	@Column(nullable = false, length = 70)
	private String nome;

	@NotBlank(message = "O e-mail é obrigatório.")
	@Email(message = "E-mail inválido.")
	@Column(nullable = false, unique = true)
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;

	@OneToMany(mappedBy = "dono")
	@JsonManagedReference
	private List<Animal> animais;

	public Pessoa() {
		super();
	}

	public Pessoa(Long id, String nome, String email, Endereco endereco, List<Animal> animais) {
	super();
	this.id = id;
	this.nome = nome;
	this.email = email;
	this.endereco = endereco;
	this.animais = animais;
	
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

	public Endereco getEndereco() {
		return endereco;
	}	

	public void setEndereco(Endereco endereco) {
				this.endereco = endereco;
	}

	public List<Animal> getAnimais() {
		return animais;
	}	

	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}



}
