package br.com.victorreis.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.victorreis.springdata.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

}
