package br.com.victorreis.springdata.service;

import java.util.List;
import java.util.Optional;

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

	public Optional<Cargo> isContemCargo(Integer id) {
		return cargoRepository.findById(id);
	}

	public List<Cargo> listar() {
		return cargoRepository.findAll();
	}

	public void deletar(Integer id) {
		cargoRepository.deleteById(id);
		
	}
	
	
	

}
