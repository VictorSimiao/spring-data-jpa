package br.com.victorreis.springdata.dto;

import java.math.BigDecimal;

import br.com.victorreis.springdata.model.Cargo;
import br.com.victorreis.springdata.model.Funcionario;
import lombok.Setter;

@Setter
public class FuncionarioRequest {

	private String nome;

	private String cpf;

	private BigDecimal salario;

	private Cargo cargo;
	
	public Funcionario toModel() {
		return new Funcionario(nome,cpf,salario,cargo);
	}
}
