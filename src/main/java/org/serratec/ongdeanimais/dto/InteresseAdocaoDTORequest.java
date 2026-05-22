package org.serratec.ongdeanimais.dto;

import org.serratec.ongdeanimais.enums.StatusInteresse;

import jakarta.validation.constraints.NotNull;

public class InteresseAdocaoDTORequest {

	@NotNull(message = "O ID da pessoa interessada é obrigatório.")
	private Long interessadoId;

	@NotNull(message = "O ID do animal é obrigatório.")
	private Long animalId;

	@NotNull(message = "O status do interesse é obrigatório.")
	private StatusInteresse status;

	public InteresseAdocaoDTORequest() {
		super();
	}

	public Long getInteressadoId() {
		return interessadoId;
	}

	public void setInteressadoId(Long interessadoId) {
		this.interessadoId = interessadoId;
	}

	public Long getAnimalId() {
		return animalId;
	}

	public void setAnimalId(Long animalId) {
		this.animalId = animalId;
	}

	public StatusInteresse getStatus() {
		return status;
	}

	public void setStatus(StatusInteresse status) {
		this.status = status;
	}

}
