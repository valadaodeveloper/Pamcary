package br.com.dts.factory.cadastroalunos.obj;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class AlunoResponse {

	private @Getter @Setter Long id;

	private @Getter @Setter String nome;

	private @Getter @Setter Integer idade;
}
