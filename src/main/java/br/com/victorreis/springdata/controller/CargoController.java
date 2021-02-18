package br.com.victorreis.springdata.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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
	public ResponseEntity<CargoDTO> criar(@RequestBody CargoRequest cargoRequest, UriComponentsBuilder uriBuilder){
		Cargo cargo = cargoRequest.toModel();
		cargoService.salvar(cargo);
		URI uri = uriBuilder.path("/cargos/{id}").buildAndExpand(cargo.getId()).toUri();
		return ResponseEntity.created(uri).body(new CargoDTO(cargo));
	}

}
