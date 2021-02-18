package br.com.victorreis.springdata.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.victorreis.springdata.model.Cargo;
import lombok.Getter;

@Getter
public class CargoDTO {
	private Integer id;
	private String descricao;
	
	public CargoDTO(Cargo cargo) {
		this.id = cargo.getId();
		this.descricao = cargo.getDescricao();
	}
	
	public static List<CargoDTO> converter(List<Cargo> cargos){
		return cargos.stream().map(CargoDTO::new).collect(Collectors.toList());
	}
}
