package br.com.victorreis.springdata.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.victorreis.springdata.model.UnidadeTrabalho;
import lombok.Getter;

@Getter
public class UnidadeTrabalhoDTO {

	private Integer id;

	private String descricao;

	private String endereco;

	public UnidadeTrabalhoDTO(UnidadeTrabalho unidadeTrabalho) {
		this.id = unidadeTrabalho.getId();
		this.descricao = unidadeTrabalho.getDescricao();
		this.endereco = unidadeTrabalho.getEndereco();
	}

	public static List<UnidadeTrabalhoDTO> converter(List<UnidadeTrabalho> unidadesTrabalho) {
		return unidadesTrabalho.stream().map(UnidadeTrabalhoDTO::new).collect(Collectors.toList());
	}
}
