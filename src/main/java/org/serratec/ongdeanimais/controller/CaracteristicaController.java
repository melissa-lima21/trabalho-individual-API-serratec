package org.serratec.ongdeanimais.controller;

import java.net.URI;
import java.util.List;

import org.serratec.ongdeanimais.dto.CaracteristicaDTORequest;
import org.serratec.ongdeanimais.dto.CaracteristicaDTOResponse;
import org.serratec.ongdeanimais.service.CaracteristicaService;
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
@RequestMapping("/caracteristicas")
public class CaracteristicaController {
	
	@Autowired
	private CaracteristicaService caracteristicaService;

	@GetMapping
	public ResponseEntity<List<CaracteristicaDTOResponse>> listar() {
		List<CaracteristicaDTOResponse> lista = caracteristicaService.findAll();
		return ResponseEntity.ok(lista);
	}

	@PostMapping
	public ResponseEntity<CaracteristicaDTOResponse> cadastrar(@Valid @RequestBody CaracteristicaDTORequest dto) {
		CaracteristicaDTOResponse salvo = caracteristicaService.inserir(dto);
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(salvo.getId())
				.toUri();
				
		return ResponseEntity.created(uri).body(salvo);
	}
}


