package br.com.victorreis.springdata.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.victorreis.springdata.model.Funcionario;
import br.com.victorreis.springdata.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	private FuncionarioRepository funcionarioRepository;

	@Autowired
	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public Funcionario save(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	
	public Optional<Funcionario> isContemFuncionario(Integer id) {
		return funcionarioRepository.findById(id);
	}
	
	public void deletar(Integer id){
		funcionarioRepository.deleteById(id);
	}

}
