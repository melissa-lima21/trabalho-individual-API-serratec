package org.serratec.ongdeanimais.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

@Entity
@Table(name = "interesse_adocao")
public class InteresseAdocao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String status;

	@NotNull(message = "A data de interesse é obrigatória.")
	@PastOrPresent(message = "A data de interesse não pode ser uma data futura.")
	@Column(name = "data_interesse", nullable = false)
	private LocalDate dataInteresse;
	
	@ManyToOne
	@JoinColumn(name = "id_pessoa", nullable = false)
	private Pessoa interessado;
	
	@ManyToOne
	@JoinColumn(name = "id_animal", nullable = false)
	private Animal animal;

	public InteresseAdocao() {
		super();
	}

	public InteresseAdocao(Long id, String status,
			@NotNull(message = "A data de interesse é obrigatória.") @PastOrPresent(message = "A data de interesse não pode ser uma data futura.") LocalDate dataInteresse,
			Pessoa interessado, Animal animal) {
		super();
		this.id = id;
		this.status = status;
		this.dataInteresse = dataInteresse;
		this.interessado = interessado;
		this.animal = animal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getDataInteresse() {
		return dataInteresse;
	}

	public void setDataInteresse(LocalDate dataInteresse) {
		this.dataInteresse = dataInteresse;
	}

	public Pessoa getInteressado() {
		return interessado;
	}

	public void setInteressado(Pessoa interessado) {
		this.interessado = interessado;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	
}
