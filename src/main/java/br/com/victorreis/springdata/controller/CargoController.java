package br.com.victorreis.springdata.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.victorreis.springdata.dto.CargoAtualizaRequest;
import br.com.victorreis.springdata.dto.CargoDTO;
import br.com.victorreis.springdata.dto.CargoRequest;
import br.com.victorreis.springdata.model.Cargo;
import br.com.victorreis.springdata.service.CargoService;

@RequestMapping("/cargos")
@RestController
public class CargoController {

	private CargoService cargoService;

	@Autowired
	public CargoController(CargoService cargoService) {
		this.cargoService = cargoService;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<CargoDTO> criar(@RequestBody CargoRequest cargoRequest, UriComponentsBuilder uriBuilder) {
		Cargo cargo = cargoRequest.toModel();
		cargoService.salvar(cargo);
		URI uri = uriBuilder.path("/cargos/{id}").buildAndExpand(cargo.getId()).toUri();
		return ResponseEntity.created(uri).body(new CargoDTO(cargo));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<CargoDTO> atualizar(@PathVariable Integer id, @RequestBody CargoAtualizaRequest request) {
		
		Optional<Cargo> optionalCargo = cargoService.isContemCargo(id);
		
		if (optionalCargo.isPresent()) {
			Cargo cargoAtualizado = request.atualizar(optionalCargo.get());
			cargoService.salvar(cargoAtualizado);
			return ResponseEntity.ok(new CargoDTO(cargoAtualizado));
		}
		return ResponseEntity.notFound().build();

	}

}
