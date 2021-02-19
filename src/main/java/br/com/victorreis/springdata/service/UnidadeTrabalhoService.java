package br.com.victorreis.springdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.victorreis.springdata.model.UnidadeTrabalho;
import br.com.victorreis.springdata.repository.UnidadeTrabalhoRepository;

@Service
public class UnidadeTrabalhoService {
	
	private UnidadeTrabalhoRepository unidadeTrabalhoRepository;
	
	@Autowired
	public UnidadeTrabalhoService(UnidadeTrabalhoRepository unidadeTrabalhoRepository) {
		this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
	}
	
	public UnidadeTrabalho save(UnidadeTrabalho unidadeTrabalho) {
		return unidadeTrabalhoRepository.save(unidadeTrabalho);
	}
	

}
