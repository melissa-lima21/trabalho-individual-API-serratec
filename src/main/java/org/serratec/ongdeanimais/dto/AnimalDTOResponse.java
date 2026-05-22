package org.serratec.ongdeanimais.dto;

import java.util.ArrayList;
import java.util.List;

import org.serratec.ongdeanimais.domain.Animal;
import org.serratec.ongdeanimais.domain.Caracteristica;
import org.serratec.ongdeanimais.enums.EspecieAnimal;
import org.serratec.ongdeanimais.enums.PerfilAnimal;

public class AnimalDTOResponse {

	private Long id;
	private String nome;
	private EspecieAnimal especie;
	private String sexo;
	private PerfilAnimal perfil;
	private Integer idade;
	private String nomeDono;
	private List<String> caracteristicas;

	public AnimalDTOResponse() {
		super();
	}

	public AnimalDTOResponse(Animal animal) {
		this.id = animal.getId();
		this.nome = animal.getNome();
		this.especie = animal.getEspecie();
		this.sexo = animal.getSexo();
		this.perfil = animal.getPerfil();
		this.idade = animal.getIdade();

		if (animal.getDono() != null) {
			this.nomeDono = animal.getDono().getNome();
		}

		this.caracteristicas = new ArrayList<>();
		if (animal.getCaracteristicas() != null) {
			for (Caracteristica c : animal.getCaracteristicas()) {
				this.caracteristicas.add(c.getDescricao());
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

	public EspecieAnimal getEspecie() {
		return especie;
	}

	public void setEspecie(EspecieAnimal especie) {
		this.especie = especie;
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

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getNomeDono() {
		return nomeDono;
	}

	public void setNomeDono(String nomeDono) {
		this.nomeDono = nomeDono;
	}

	public List<String> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(List<String> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

}
