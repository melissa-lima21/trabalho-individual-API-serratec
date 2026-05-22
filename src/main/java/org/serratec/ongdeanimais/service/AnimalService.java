package org.serratec.ongdeanimais.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.ongdeanimais.domain.Animal;
import org.serratec.ongdeanimais.domain.Caracteristica;
import org.serratec.ongdeanimais.domain.Pessoa;
import org.serratec.ongdeanimais.dto.AnimalDTORequest;
import org.serratec.ongdeanimais.dto.AnimalDTOResponse;
import org.serratec.ongdeanimais.exception.SolicitacaoNaoEncontradaException;
import org.serratec.ongdeanimais.repository.AnimalRepository;
import org.serratec.ongdeanimais.repository.CaracteristicaRepository;
import org.serratec.ongdeanimais.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnimalService {

	@Autowired
	private AnimalRepository animalRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private CaracteristicaRepository caracteristicaRepository;

	public List<AnimalDTOResponse> findAll() {
		List<Animal> animais = animalRepository.findAll();
		List<AnimalDTOResponse> dtos = new ArrayList<>();
		for (Animal animal : animais) {
			dtos.add(new AnimalDTOResponse(animal));
		}
		return dtos;
	}

	public AnimalDTOResponse buscarPorId(Long id) {
		Animal animal = animalRepository.findById(id)
				.orElseThrow(() -> new SolicitacaoNaoEncontradaException("ID desse animal não foi encontrado."));
		return new AnimalDTOResponse(animal);
	}

	@Transactional
	public AnimalDTOResponse inserir(AnimalDTORequest dto) {
		Animal animal = new Animal();
		preencherDados(animal, dto);
		animal = animalRepository.save(animal);
		return new AnimalDTOResponse(animal);
	}

	@Transactional
	public AnimalDTOResponse atualizar(Long id, AnimalDTORequest dto) {
		Animal animalExistente = animalRepository.findById(id)
				.orElseThrow(() -> new SolicitacaoNaoEncontradaException("ID não encontrado."));

		preencherDados(animalExistente, dto);
		animalExistente = animalRepository.save(animalExistente);
		return new AnimalDTOResponse(animalExistente);
	}

	@Transactional
	public void remover(Long id) {
		if (!animalRepository.existsById(id)) {
			throw new SolicitacaoNaoEncontradaException("Não é possível remover. ID  não encontrado.");
		}
		animalRepository.deleteById(id);
	}

	private void preencherDados(Animal animal, AnimalDTORequest dto) {
		animal.setNome(dto.getNome());
		animal.setEspecie(dto.getEspecie());
		animal.setSexo(dto.getSexo());
		animal.setPerfil(dto.getPerfil());
		animal.setIdade(dto.getIdade());

		if (dto.getDonoId() != null) {
			Pessoa dono = pessoaRepository.findById(dto.getDonoId())
					.orElseThrow(() -> new SolicitacaoNaoEncontradaException("ID de dono não encontrado."));
			animal.setDono(dono);
		} else {
			animal.setDono(null);
		}

		if (dto.getCaracteristicasIds() != null && !dto.getCaracteristicasIds().isEmpty()) {
			List<Caracteristica> caracteristicas = caracteristicaRepository.findAllById(dto.getCaracteristicasIds());
			animal.setCaracteristicas(caracteristicas);
		} else {
			animal.setCaracteristicas(new ArrayList<>());
		}
	}
}
