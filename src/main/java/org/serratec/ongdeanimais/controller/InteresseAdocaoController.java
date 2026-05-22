package org.serratec.ongdeanimais.controller;

import java.net.URI;
import java.util.List;

import org.serratec.ongdeanimais.dto.InteresseAdocaoDTORequest;
import org.serratec.ongdeanimais.dto.InteresseAdocaoDTOResponse;
import org.serratec.ongdeanimais.service.InteresseAdocaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/interesses")
public class InteresseAdocaoController {

	@Autowired
	private InteresseAdocaoService interesseService;

	@GetMapping
	public ResponseEntity<List<InteresseAdocaoDTOResponse>> listar() {
		return ResponseEntity.ok(interesseService.findAll());
	}

	@PostMapping
	public ResponseEntity<InteresseAdocaoDTOResponse> cadastrar(@Valid @RequestBody InteresseAdocaoDTORequest dto) {
		InteresseAdocaoDTOResponse salvo = interesseService.inserir(dto);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(salvo.getId()).toUri();

		return ResponseEntity.created(uri).body(salvo);
	}
}
