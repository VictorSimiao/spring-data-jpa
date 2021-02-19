package br.com.victorreis.springdata.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.victorreis.springdata.dto.UnidadeTrabalhoDTO;
import br.com.victorreis.springdata.dto.UnidadeTrabalhoRequest;
import br.com.victorreis.springdata.model.UnidadeTrabalho;
import br.com.victorreis.springdata.service.UnidadeTrabalhoService;

@RequestMapping("/unidadestrabalho")
@RestController
public class UnidadeTrabalhoController {

	private UnidadeTrabalhoService unidadeTrabalhoService;

	@Autowired
	public UnidadeTrabalhoController(UnidadeTrabalhoService unidadeTrabalhoService) {
		this.unidadeTrabalhoService = unidadeTrabalhoService;
	}
	
	@PostMapping
	public ResponseEntity<UnidadeTrabalhoDTO> criar(@RequestBody UnidadeTrabalhoRequest request,
			UriComponentsBuilder uriBuilder) {
		UnidadeTrabalho unidadeTrabalho = request.toModel();
		unidadeTrabalhoService.save(unidadeTrabalho);
		URI uri = uriBuilder.path("/unidades/{id}").buildAndExpand(unidadeTrabalho.getId()).toUri();
		return ResponseEntity.created(uri).body(new UnidadeTrabalhoDTO(unidadeTrabalho));

	}

}
