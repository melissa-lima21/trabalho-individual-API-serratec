package org.serratec.ongdeanimais.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.ongdeanimais.domain.Pessoa;
import org.serratec.ongdeanimais.dto.PessoaDTORequest;
import org.serratec.ongdeanimais.dto.PessoaDTOResponse;
import org.serratec.ongdeanimais.exception.DuplicateEntryException;
import org.serratec.ongdeanimais.exception.SolicitacaoNaoEncontradaException;
import org.serratec.ongdeanimais.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public List<PessoaDTOResponse> findAll() {
		List<Pessoa> pessoas = pessoaRepository.findAll();
		List<PessoaDTOResponse> pessoasDTO = new ArrayList<PessoaDTOResponse>();

		for (Pessoa pessoa : pessoas) {
			pessoasDTO.add(new PessoaDTOResponse(pessoa));
		}

		return pessoasDTO;
	}

	public PessoaDTOResponse buscarPorId(Long id) {
		Pessoa pessoa = pessoaRepository.findById(id)
				.orElseThrow(() -> new SolicitacaoNaoEncontradaException("ID não encontrado."));
		return new PessoaDTOResponse(pessoa);
	}

	@Transactional
	public PessoaDTOResponse inserir(PessoaDTORequest pessoaDTO) {
		Optional<Pessoa> pessoaExistente = pessoaRepository.findByEmail(pessoaDTO.getEmail());
		if (pessoaExistente.isPresent()) {
			throw new DuplicateEntryException("Email já cadastrado");
		}
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(pessoaDTO.getNome());
		pessoa.setEmail(pessoaDTO.getEmail());

		pessoa = pessoaRepository.save(pessoa);
		return new PessoaDTOResponse(pessoa);
	}

	@Transactional
	public PessoaDTOResponse atualizar(Long id, PessoaDTORequest pessoaDTO) {
		Pessoa buscarPorId = pessoaRepository.findById(id)
				.orElseThrow(() -> new SolicitacaoNaoEncontradaException("ID não encontrado."));
		buscarPorId.setNome(pessoaDTO.getNome());
		buscarPorId.setEmail(pessoaDTO.getEmail());
		buscarPorId = pessoaRepository.save(buscarPorId);
		return new PessoaDTOResponse(buscarPorId);
	}

	public void remover(Long id) {
		if (!pessoaRepository.existsById(id)) {
			throw new SolicitacaoNaoEncontradaException("ID não encontrado.");
		}

		pessoaRepository.deleteById(id);
	}

}
