package org.serratec.ongdeanimais.controller;

import java.net.URI;
import java.util.List;

import org.serratec.ongdeanimais.dto.AnimalDTORequest;
import org.serratec.ongdeanimais.dto.AnimalDTOResponse;
import org.serratec.ongdeanimais.service.AnimalService;
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
@RequestMapping("/animais")
public class AnimalController {

	@Autowired
	private AnimalService animalService;

	@GetMapping
	public ResponseEntity<List<AnimalDTOResponse>> listar() {
		return ResponseEntity.ok(animalService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<AnimalDTOResponse> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(animalService.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<AnimalDTOResponse> cadastrar(@Valid @RequestBody AnimalDTORequest dto) {
		AnimalDTOResponse animalSalvo = animalService.inserir(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(animalSalvo.getId())
				.toUri();
		return ResponseEntity.created(uri).body(animalSalvo);
	}

	@PutMapping("/{id}")
	public ResponseEntity<AnimalDTOResponse> atualizar(@PathVariable Long id,
			@Valid @RequestBody AnimalDTORequest dto) {
		return ResponseEntity.ok(animalService.atualizar(id, dto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		animalService.remover(id);
		return ResponseEntity.noContent().build();
	}
}
