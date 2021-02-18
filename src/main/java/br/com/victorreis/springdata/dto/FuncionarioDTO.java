package br.com.victorreis.springdata.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.victorreis.springdata.model.Cargo;
import br.com.victorreis.springdata.model.Funcionario;
import lombok.Getter;

@Getter
public class FuncionarioDTO {
	private Integer id;
	
	private String nome;
	
	private String cpf;
	
	private BigDecimal salario;
	
	private LocalDate dataContratacao = LocalDate.now();
	
	private Cargo cargo;
	
	public FuncionarioDTO(Funcionario funcionario) {
		this.id = funcionario.getId();
		this.nome = funcionario.getNome();
		this.cpf = funcionario.getCpf();
		this.salario = funcionario.getSalario();
		this.dataContratacao = funcionario.getDataContratacao();
		this.cargo = funcionario.getCargo();
	}
	
	public static List<FuncionarioDTO> converter(List<Funcionario> funcionarios){
		return funcionarios.stream().map(FuncionarioDTO::new).collect(Collectors.toList());
	}
}
