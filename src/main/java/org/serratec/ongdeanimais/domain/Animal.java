package org.serratec.ongdeanimais.domain;

import java.util.List;

import org.serratec.ongdeanimais.enums.EspecieAnimal;
import org.serratec.ongdeanimais.enums.PerfilAnimal;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "animal")
public class Animal {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome é obrigatório.")
	@Size(max = 20)
	@Column(nullable = false, length = 20)
	private String nome;
	
	@NotNull(message = "A espécie é obrigatória.")
	@Enumerated(EnumType.STRING)
	private EspecieAnimal especie;
	
	@NotBlank(message = "Digite [M] para 'macho' ou [F] para 'fêmea'.")
	@Size(max = 1)
	@Column(length = 1)
	private String sexo;
	
	@NotNull(message = "O perfil do animal é obrigatório.")
	@Enumerated(EnumType.STRING)
	private PerfilAnimal perfil;
	
	@PositiveOrZero(message = "A idade do animal não pode ser um número negativo.")
	private Integer idade;
	
	@ManyToOne
	@JoinColumn(name = "id_pessoa")
	@JsonBackReference
	private Pessoa dono;
	
	@ManyToMany
	@JoinTable(name = "caracteristica_animal",
	joinColumns = @JoinColumn(name = "id_animal"),
	inverseJoinColumns = @JoinColumn(name = "id_caracteristica"))
	private List<Caracteristica> caracteristicas;

	public Animal() {
		super();
	}

	public Animal(Long id, String nome, EspecieAnimal especie, Integer idade, String sexo, PerfilAnimal perfil,
			Pessoa dono, List<Caracteristica> caracteristicas) {

		super();
		this.id = id;
		this.nome = nome;
		this.especie = especie;
		this.sexo = sexo;
		this.perfil = perfil;
		this.idade = idade;
		this.dono = dono;
		this.caracteristicas = caracteristicas;
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

	public EspecieAnimal getEspecie() {
		return especie;
	}

	public void setEspecie(EspecieAnimal especie) {
		this.especie = especie;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public PerfilAnimal getPerfil() {
		return perfil;
	}
	
	public void setPerfil(PerfilAnimal perfil) {
		this.perfil = perfil;
		
	}

	public Pessoa getDono() {
		return dono;
	}

	public void setDono(Pessoa dono) {
		this.dono = dono;
	}

	public List<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(List<Caracteristica> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	
	

}
