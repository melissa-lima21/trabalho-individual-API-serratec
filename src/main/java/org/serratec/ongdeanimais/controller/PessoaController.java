package org.serratec.ongdeanimais.controller;

import java.net.URI;
import java.util.List;

import org.serratec.ongdeanimais.dto.PessoaDTORequest;
import org.serratec.ongdeanimais.dto.PessoaDTOResponse;
import org.serratec.ongdeanimais.service.PessoaService;
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
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@GetMapping
	public ResponseEntity<List<PessoaDTOResponse>> listar() {
		List<PessoaDTOResponse> pessoas = pessoaService.findAll();
		return ResponseEntity.ok(pessoas);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PessoaDTOResponse> buscarPorId(@PathVariable Long id) {
		PessoaDTOResponse pessoa = pessoaService.buscarPorId(id);
		return ResponseEntity.ok(pessoa);
	}

	@PostMapping
	public ResponseEntity<PessoaDTOResponse> cadastrar(@Valid @RequestBody PessoaDTORequest pessoaDTO) {
		PessoaDTOResponse pessoaSalva = pessoaService.inserir(pessoaDTO);
		URI uri = ServletUriComponentsBuilder
	            .fromCurrentRequest()
	            .path("/{id}")
	            .buildAndExpand(pessoaSalva.getId())
	            .toUri();
		
		return ResponseEntity.created(uri).body(pessoaSalva);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PessoaDTOResponse> atualizar(@PathVariable Long id, @Valid @RequestBody PessoaDTORequest pessoaDTO) {
		PessoaDTOResponse pessoaAtualizada = pessoaService.atualizar(id, pessoaDTO);
		return ResponseEntity.ok(pessoaAtualizada);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		pessoaService.remover(id);
		return ResponseEntity.noContent().build();
	}
}


