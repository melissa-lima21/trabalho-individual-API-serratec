package org.serratec.ongdeanimais.dto;

import org.serratec.ongdeanimais.domain.Caracteristica;

public class CaracteristicaDTOResponse {

	private Long id;
	private String descricao;
	
	public CaracteristicaDTOResponse(Caracteristica caracteristica) {
		this.id = caracteristica.getId();
		this.descricao = caracteristica.getDescricao();
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
	
}
