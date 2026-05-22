package org.serratec.ongdeanimais.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.ongdeanimais.domain.Endereco;
import org.serratec.ongdeanimais.dto.EnderecoDTORequest;
import org.serratec.ongdeanimais.dto.EnderecoDTOResponse;
import org.serratec.ongdeanimais.exception.SolicitacaoNaoEncontradaException;
import org.serratec.ongdeanimais.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	public List<EnderecoDTOResponse> findAll() {
		List<Endereco> enderecos = enderecoRepository.findAll();
		List<EnderecoDTOResponse> enderecosDTO = new ArrayList<>();

		for (Endereco endereco : enderecos) {
			enderecosDTO.add(new EnderecoDTOResponse(endereco));
		}
		return enderecosDTO;
	}

	public EnderecoDTOResponse buscarPorId(Long id) {
		Endereco endereco = enderecoRepository.findById(id)
				.orElseThrow(() -> new SolicitacaoNaoEncontradaException("Endereço de ID não encontrado."));
		return new EnderecoDTOResponse(endereco);
	}

	@Transactional
	public EnderecoDTOResponse inserir(EnderecoDTORequest dto) {
		Endereco endereco = new Endereco();
		endereco.setRua(dto.getRua());
		endereco.setNumero(dto.getNumero());
		endereco.setBairro(dto.getBairro());
		endereco.setCidade(dto.getCidade());
		endereco.setEstado(dto.getEstado());

		endereco = enderecoRepository.save(endereco);
		return new EnderecoDTOResponse(endereco);
	}

	@Transactional
	public EnderecoDTOResponse atualizar(Long id, EnderecoDTORequest dto) {
		Endereco enderecoExistente = enderecoRepository.findById(id)
				.orElseThrow(() -> new SolicitacaoNaoEncontradaException("ID não encontrado."));

		enderecoExistente.setRua(dto.getRua());
		enderecoExistente.setNumero(dto.getNumero());
		enderecoExistente.setBairro(dto.getBairro());
		enderecoExistente.setCidade(dto.getCidade());
		enderecoExistente.setEstado(dto.getEstado());

		enderecoExistente = enderecoRepository.save(enderecoExistente);
		return new EnderecoDTOResponse(enderecoExistente);
	}

	@Transactional
	public void remover(Long id) {
		if (!enderecoRepository.existsById(id)) {
			throw new SolicitacaoNaoEncontradaException("Não foi possível deletar. Endereço não encontrado.");
		}
		enderecoRepository.deleteById(id);
	}
}
