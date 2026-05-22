package org.serratec.ongdeanimais.dto;

import java.util.List;

import org.serratec.ongdeanimais.enums.EspecieAnimal;
import org.serratec.ongdeanimais.enums.PerfilAnimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class AnimalDTORequest {

	@NotBlank(message = "O nome é obrigatório.")
	@Size(max = 20)
	private String nome;

	@NotNull(message = "A espécie é obrigatória.")
	private EspecieAnimal especie;

	@NotBlank(message = "Digite [M] para 'macho' ou [F] para 'fêmea'.")
	@Size(max = 1)
	private String sexo;

	@NotNull(message = "O perfil do animal é obrigatório.")
	private PerfilAnimal perfil;

	@PositiveOrZero(message = "A idade do animal não pode ser um número negativo.")
	private Integer idade;

	private Long donoId;

	private List<Long> caracteristicasIds;

	public AnimalDTORequest() {
		super();
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

	public Long getDonoId() {
		return donoId;
	}

	public void setDonoId(Long donoId) {
		this.donoId = donoId;
	}

	public List<Long> getCaracteristicasIds() {
		return caracteristicasIds;
	}

	public void setCaracteristicasIds(List<Long> caracteristicasIds) {
		this.caracteristicasIds = caracteristicasIds;
	}

}
