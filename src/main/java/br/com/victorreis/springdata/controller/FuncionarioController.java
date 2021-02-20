package br.com.victorreis.springdata.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.victorreis.springdata.dto.FuncionarioDTO;
import br.com.victorreis.springdata.dto.FuncionarioRequest;
import br.com.victorreis.springdata.model.Funcionario;
import br.com.victorreis.springdata.repository.FuncionarioRepository;
import br.com.victorreis.springdata.service.FuncionarioService;

@RequestMapping("/funcionarios")
@RestController
public class FuncionarioController {

	private FuncionarioService funcionarioService;

	private FuncionarioRepository funcionarioRepository;

	@Autowired
	public FuncionarioController(FuncionarioService funcionarioService, FuncionarioRepository funcionarioRepository) {
		this.funcionarioService = funcionarioService;
		this.funcionarioRepository = funcionarioRepository;
	}

	@GetMapping
	public ResponseEntity<List<FuncionarioDTO>> listarTodos() {
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		return ResponseEntity.ok(FuncionarioDTO.converter(funcionarios));
	}

	@GetMapping("por-nome")
	public ResponseEntity<List<FuncionarioDTO>> listarPorNome(String nome) {
		List<Funcionario> funcionarios = funcionarioRepository.findByNome(nome);
		return ResponseEntity.ok(FuncionarioDTO.converter(funcionarios));
	}

	@PostMapping
	@Transactional
	public ResponseEntity<FuncionarioDTO> criar(@RequestBody FuncionarioRequest request,
			UriComponentsBuilder uriBuilder) {
		Funcionario funcionario = request.toModel();
		funcionarioService.save(funcionario);
		URI uri = uriBuilder.path("/cargos/{id}").buildAndExpand(funcionario.getId()).toUri();
		return ResponseEntity.created(uri).body(new FuncionarioDTO(funcionario));
	}

}
