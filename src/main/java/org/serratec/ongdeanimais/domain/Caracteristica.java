package org.serratec.ongdeanimais.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "caracteristica")
public class Caracteristica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "A descrição da característica é obrigatória.")
	@Size(max = 30)
	@Column(nullable = false, unique = true, length = 30)
	private String descricao;

	@ManyToMany(mappedBy = "caracteristicas")
	@JsonIgnore
	private List<Animal> animais;

	public Caracteristica() {
		super();
	}

	public Caracteristica(Long id, String descricao, List<Animal> animais) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.animais = animais;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}
	
	
}


