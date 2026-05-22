package org.serratec.ongdeanimais.controller;

import java.net.URI;
import java.util.List;

import org.serratec.ongdeanimais.dto.EnderecoDTORequest;
import org.serratec.ongdeanimais.dto.EnderecoDTOResponse;
import org.serratec.ongdeanimais.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	@GetMapping
	public ResponseEntity<List<EnderecoDTOResponse>> listar() {
		List<EnderecoDTOResponse> enderecos = enderecoService.findAll();
		return ResponseEntity.ok(enderecos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EnderecoDTOResponse> buscarPorId(@PathVariable Long id) {
		EnderecoDTOResponse endereco = enderecoService.buscarPorId(id);
		return ResponseEntity.ok(endereco);
	}

	@PostMapping
	public ResponseEntity<EnderecoDTOResponse> cadastrar(@Valid @RequestBody EnderecoDTORequest enderecoDTO) {
		EnderecoDTOResponse enderecoSalvo = enderecoService.inserir(enderecoDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(enderecoSalvo.getId())
				.toUri();

		return ResponseEntity.created(uri).body(enderecoSalvo);
	}

	@PutMapping("/{id}")
	public ResponseEntity<EnderecoDTOResponse> atualizar(@PathVariable Long id,
			@Valid @RequestBody EnderecoDTORequest enderecoDTO) {
		EnderecoDTOResponse enderecoAtualizado = enderecoService.atualizar(id, enderecoDTO);
		return ResponseEntity.ok(enderecoAtualizado);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		enderecoService.remover(id);
		return ResponseEntity.noContent().build();
	}
}
