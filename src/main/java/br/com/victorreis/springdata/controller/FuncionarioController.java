package br.com.victorreis.springdata.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.victorreis.springdata.dto.FuncionarioDTO;
import br.com.victorreis.springdata.dto.FuncionarioRequest;
import br.com.victorreis.springdata.model.Funcionario;
import br.com.victorreis.springdata.service.FuncionarioService;

@RequestMapping("/funcionarios")
@RestController
public class FuncionarioController {
	
	private FuncionarioService funcionarioService;
	
	@Autowired
	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}


	@PostMapping
	@Transactional
	public ResponseEntity<FuncionarioDTO> criar(@RequestBody FuncionarioRequest request,UriComponentsBuilder uriBuilder){
		Funcionario funcionario = request.toModel();
		funcionarioService.save(funcionario);
		URI uri = uriBuilder.path("/cargos/{id}").buildAndExpand(funcionario.getId()).toUri();
		return ResponseEntity.created(uri).body(new FuncionarioDTO(funcionario));
	}

}
