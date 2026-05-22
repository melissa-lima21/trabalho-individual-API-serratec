package org.serratec.ongdeanimais.dto;

import java.time.LocalDate;

import org.serratec.ongdeanimais.domain.InteresseAdocao;
import org.serratec.ongdeanimais.enums.StatusInteresse;

public class InteresseAdocaoDTOResponse {

	private Long id;
	private StatusInteresse status;
	private LocalDate dataInteresse;
	private String nomeInteressado;
	private String nomeAnimal;

	public InteresseAdocaoDTOResponse() {
		super();
	}

	public InteresseAdocaoDTOResponse(InteresseAdocao interesse) {
		this.id = interesse.getId();
		this.status = interesse.getStatus();
		this.dataInteresse = interesse.getDataInteresse();

		if (interesse.getInteressado() != null) {
			this.nomeInteressado = interesse.getInteressado().getNome();
		}
		if (interesse.getAnimal() != null) {
			this.nomeAnimal = interesse.getAnimal().getNome();
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StatusInteresse getStatus() {
		return status;
	}

	public void setStatus(StatusInteresse status) {
		this.status = status;
	}

	public LocalDate getDataInteresse() {
		return dataInteresse;
	}

	public void setDataInteresse(LocalDate dataInteresse) {
		this.dataInteresse = dataInteresse;
	}

	public String getNomeInteressado() {
		return nomeInteressado;
	}

	public void setNomeInteressado(String nomeInteressado) {
		this.nomeInteressado = nomeInteressado;
	}

	public String getNomeAnimal() {
		return nomeAnimal;
	}

	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}

}
