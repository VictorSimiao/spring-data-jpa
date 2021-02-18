package br.com.victorreis.springdata.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.victorreis.springdata.model.Cargo;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Integer> {

}
