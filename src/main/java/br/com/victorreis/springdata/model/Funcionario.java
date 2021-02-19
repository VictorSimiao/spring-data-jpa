package br.com.victorreis.springdata.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@Getter
@Entity
@Table(name = "funcionarios")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer id;

	private String nome;

	private String cpf;

	private BigDecimal salario;

	private LocalDate dataContratacao = LocalDate.now();

	@ManyToOne
	@JoinColumn(name = "cargo_id", nullable = false)
	private Cargo cargo;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "funcionarios_unidades",
		joinColumns =
		{@JoinColumn(name="fk_funcionario")},
		inverseJoinColumns = {@JoinColumn(name="fk_unidade")})
	private List<UnidadeTrabalho> unidadesTrabalho;

	public Funcionario() {

	}

	public Funcionario(String nome, String cpf, BigDecimal salario, Cargo cargo) {
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
		this.cargo = cargo;
	}

}
