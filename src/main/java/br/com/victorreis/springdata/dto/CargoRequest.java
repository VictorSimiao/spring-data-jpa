package br.com.victorreis.springdata.dto;

import br.com.victorreis.springdata.model.Cargo;
import lombok.Setter;

@Setter
public class CargoRequest {
	
	private String descricao;
	
	public Cargo toModel() {
		return new Cargo(descricao);
	}
}
