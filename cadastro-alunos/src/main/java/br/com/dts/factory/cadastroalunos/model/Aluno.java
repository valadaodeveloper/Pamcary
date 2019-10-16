package br.com.dts.factory.cadastroalunos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ALUNO")
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGenAlunos")
	@SequenceGenerator(name = "seqGenAlunos", sequenceName = "ALUNOS_SEQ")
	@Column(name = "ID_CLIENTE")
	@Getter
	@Setter
	private Long id;
	@NotNull
	@Column(name = "NOME", length = 100)
	@Getter
	@Setter
	private String nome;
	@Column(name = "IDADE", length = 3)
	@Getter
	@Setter
	private Integer idade;

}
