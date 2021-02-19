package br.com.victorreis.springdata.dto;

import br.com.victorreis.springdata.model.UnidadeTrabalho;
import lombok.Setter;

@Setter
public class UnidadeTrabalhoRequest {
	
	private String descricao;

	private String endereco;
	
	public UnidadeTrabalho toModel() {
		return new UnidadeTrabalho(descricao,endereco);
	}

}
