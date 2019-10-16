package br.com.dts.factory.cadastroalunos.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.dts.factory.cadastroalunos.model.Aluno;
import br.com.dts.factory.cadastroalunos.obj.AlunoRequest;
import br.com.dts.factory.cadastroalunos.obj.AlunoResponse;

@Component
public class AlunoConverter {

	public List<AlunoResponse> converterListaEntidade(List<Aluno> listaEntidade) {

		List<AlunoResponse> listaResponse = new ArrayList<>();
		for (Aluno entidade : listaEntidade) {
			AlunoResponse response = new AlunoResponse();
			response.setId(entidade.getId());
			response.setIdade(entidade.getIdade());
			response.setNome(entidade.getNome());

			listaResponse.add(response);
		}

		return listaResponse;
	}

	public AlunoResponse converterEntidade(Aluno entidadeAluno) {
		AlunoResponse response = new AlunoResponse();
		response.setId(entidadeAluno.getId());
		response.setIdade(entidadeAluno.getIdade());
		response.setNome(entidadeAluno.getNome());

		return response;
	}

	public Aluno converterRequest(AlunoRequest alunoRequest) {

		Aluno entidadeAluno = new Aluno();
		entidadeAluno.setIdade(alunoRequest.getIdade());
		entidadeAluno.setNome(alunoRequest.getNome());
		return entidadeAluno;
	}
}
