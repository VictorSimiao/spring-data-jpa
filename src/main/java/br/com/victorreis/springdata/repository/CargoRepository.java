package br.com.victorreis.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.victorreis.springdata.model.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {

}
