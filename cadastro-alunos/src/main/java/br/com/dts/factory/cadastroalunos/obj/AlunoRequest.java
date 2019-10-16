package br.com.dts.factory.cadastroalunos.obj;

import lombok.Getter;
import lombok.Setter;

public class AlunoRequest {

	@Getter
	@Setter
	private Long id;
	@Getter
	@Setter
	private String nome;
	@Getter
	@Setter
	private Integer idade;

}
