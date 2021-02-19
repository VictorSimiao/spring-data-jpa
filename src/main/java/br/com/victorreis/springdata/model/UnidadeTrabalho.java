package br.com.victorreis.springdata.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@Getter
@Entity
@Table(name = "Unidades_Trabalho")
public class UnidadeTrabalho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer id;

	private String descricao;

	private String endereco;

	public UnidadeTrabalho() {
	}

	public UnidadeTrabalho(String descricao, String endereco) {
		this.descricao = descricao;
		this.endereco = endereco;
	}

}
