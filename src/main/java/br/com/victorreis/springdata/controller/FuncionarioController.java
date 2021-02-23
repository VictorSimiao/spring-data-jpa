package br.com.victorreis.springdata.controller;

import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/{id}")
	public ResponseEntity<FuncionarioDTO> detalhar(@PathVariable Integer id) {
		Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(id);
		if (funcionarioOptional.isPresent()) {
			return ResponseEntity.ok(new FuncionarioDTO(funcionarioOptional.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("por-nome")
	public ResponseEntity<List<FuncionarioDTO>> listarPorNome(String nome) {
		List<Funcionario> funcionarios = funcionarioRepository.findByNome(nome);
		return ResponseEntity.ok(FuncionarioDTO.converter(funcionarios));
	}

	@GetMapping("por-cargo")
	public ResponseEntity<List<FuncionarioDTO>> listarPorCargo(String cargo) {
		List<Funcionario> funcionarios = funcionarioRepository.findByCargoDescricao(cargo);
		return ResponseEntity.ok(FuncionarioDTO.converter(funcionarios));
	}

	@GetMapping("data-contratacao-a-partir-de")
	public ResponseEntity<List<FuncionarioDTO>> listarPorDataContratacao(String data) {
		LocalDate dataConvertida = LocalDate.parse(data, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		List<Funcionario> funcionarios = funcionarioRepository.findDataContratacaoMaiorOuIgual(dataConvertida);
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

	@DeleteMapping("/{id}")
	public ResponseEntity<FuncionarioDTO> deletar(@PathVariable Integer id) {
		Optional<Funcionario> contemFuncionario = funcionarioService.isContemFuncionario(id);
		if (contemFuncionario.isPresent()) {
			funcionarioService.deletar(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

}
