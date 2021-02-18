package br.com.victorreis.springdata.dto;

import br.com.victorreis.springdata.model.Cargo;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class CargoAtualizaRequest {
	
	private String descricao;

	public Cargo atualizar(Cargo cargo) {
		cargo.setDescricao(descricao);
		return cargo;
	}
	
}
