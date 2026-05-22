package org.serratec.ongdeanimais.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.serratec.ongdeanimais.domain.Animal;
import org.serratec.ongdeanimais.domain.InteresseAdocao;
import org.serratec.ongdeanimais.domain.Pessoa;
import org.serratec.ongdeanimais.dto.InteresseAdocaoDTORequest;
import org.serratec.ongdeanimais.dto.InteresseAdocaoDTOResponse;
import org.serratec.ongdeanimais.exception.SolicitacaoNaoEncontradaException;
import org.serratec.ongdeanimais.repository.AnimalRepository;
import org.serratec.ongdeanimais.repository.InteresseAdocaoRepository;
import org.serratec.ongdeanimais.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InteresseAdocaoService {
	
	@Autowired
	private InteresseAdocaoRepository interesseRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private AnimalRepository animalRepository;
	
	public List<InteresseAdocaoDTOResponse> findAll() {
		List<InteresseAdocao> lista = interesseRepository.findAll();
		List<InteresseAdocaoDTOResponse> dtos = new ArrayList<>();
		for (InteresseAdocao i : lista) {
			dtos.add(new InteresseAdocaoDTOResponse(i));
		}
		return dtos;
	}

	@Transactional
	public InteresseAdocaoDTOResponse inserir(InteresseAdocaoDTORequest dto) {
		Pessoa interessado = pessoaRepository.findById(dto.getInteressadoId())
				.orElseThrow(() -> new SolicitacaoNaoEncontradaException("ID de pessoa interessada não foi encontrado."));
				
				Animal animal = animalRepository.findById(dto.getAnimalId())
				.orElseThrow(() -> new SolicitacaoNaoEncontradaException("ID do animal não foi encontrado."));
				InteresseAdocao interesse = new InteresseAdocao();
				interesse.setInteressado(interessado);
				interesse.setAnimal(animal);
				interesse.setStatus(dto.getStatus());
				interesse.setDataInteresse(LocalDate.now());
				
				interesse = interesseRepository.save(interesse);
				return new InteresseAdocaoDTOResponse(interesse);
	}
}
