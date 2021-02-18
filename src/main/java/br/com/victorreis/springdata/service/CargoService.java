package br.com.victorreis.springdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.victorreis.springdata.model.Cargo;
import br.com.victorreis.springdata.repository.CargoRepository;

@Service
public class CargoService {
	
	
	private CargoRepository cargoRepository;

	@Autowired
	public CargoService(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}
	
	public Cargo salvar(Cargo cargo) {
		return cargoRepository.save(cargo);
	}
	
	
	

}
