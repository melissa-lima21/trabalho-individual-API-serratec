package org.serratec.ongdeanimais.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CaracteristicaDTORequest {
	
	@NotBlank(message = "A descrição da característica é obrigatória.")
	@Size(max = 30, message = "A descrição só pode ter até 30 caracteres.")
	private String descricao;

	public CaracteristicaDTORequest() {
		super();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}

