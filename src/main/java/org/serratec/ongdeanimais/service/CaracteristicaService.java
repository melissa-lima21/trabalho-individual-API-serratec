package org.serratec.ongdeanimais.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.ongdeanimais.domain.Caracteristica;
import org.serratec.ongdeanimais.dto.CaracteristicaDTORequest;
import org.serratec.ongdeanimais.dto.CaracteristicaDTOResponse;
import org.serratec.ongdeanimais.exception.DuplicateEntryException;
import org.serratec.ongdeanimais.repository.CaracteristicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CaracteristicaService {

	@Autowired
	private CaracteristicaRepository caracteristicaRepository;

	public List<CaracteristicaDTOResponse> findAll() {
		List<Caracteristica> caracteristicas = caracteristicaRepository.findAll();
		List<CaracteristicaDTOResponse> dtos = new ArrayList<>();

		for (Caracteristica c : caracteristicas) {
			dtos.add(new CaracteristicaDTOResponse(c));
		}
		return dtos;
	}

	@Transactional
	public CaracteristicaDTOResponse inserir(CaracteristicaDTORequest dto) {
		if (caracteristicaRepository.existsByDescricao(dto.getDescricao())) {
			throw new DuplicateEntryException("A característica escolhida já está cadastrada.");
		}
		Caracteristica caracteristica = new Caracteristica();
		caracteristica.setDescricao(dto.getDescricao());
		caracteristica = caracteristicaRepository.save(caracteristica);
		return new CaracteristicaDTOResponse(caracteristica);
	}
}
