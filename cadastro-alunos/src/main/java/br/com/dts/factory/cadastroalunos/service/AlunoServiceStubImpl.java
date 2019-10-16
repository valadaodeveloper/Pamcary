package br.com.dts.factory.cadastroalunos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import br.com.dts.factory.cadastroalunos.handler.ApiException;
import br.com.dts.factory.cadastroalunos.model.Aluno;
import br.com.dts.factory.cadastroalunos.obj.AlunoRequest;
import br.com.dts.factory.cadastroalunos.obj.AlunoResponse;
import br.com.dts.factory.cadastroalunos.repository.AlunoRepository;
import br.com.dts.factory.cadastroalunos.utils.AlunoConverter;

@Component
public class AlunoServiceStubImpl {

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private AlunoConverter alunoConverter;

	@Autowired
	private Environment env;

	public List<AlunoResponse> consultarTodosAlunos() {

		List<Aluno> listaAlunosEntidade = new ArrayList<>();
		listaAlunosEntidade = alunoRepository.findAll();
		List<AlunoResponse> listaResponse = new ArrayList<>();

		if (!listaAlunosEntidade.isEmpty()) {
			listaResponse = alunoConverter.converterListaEntidade(listaAlunosEntidade);
		} else {
			throw new ApiException(env.getProperty("sem.informacoes"));
		}

		return listaResponse;
	}

	public AlunoResponse consultarAlunoId(Long idAluno) {
		Optional<Aluno> entidadeAluno = alunoRepository.findById(idAluno);
		AlunoResponse response = new AlunoResponse();
		if (entidadeAluno.isPresent()) {
			response = alunoConverter.converterEntidade(entidadeAluno.get());
		} else {
			throw new ApiException(env.getProperty("erro.id"));
		}
		return response;
	}

	public AlunoResponse inserirAluno(AlunoRequest alunoRequest) {
		
		Aluno entidadeAluno = alunoConverter.converterRequest(alunoRequest);
		AlunoResponse response = new AlunoResponse();
		try {
		entidadeAluno = alunoRepository.save(entidadeAluno);
	response = alunoConverter.converterEntidade(entidadeAluno);
		}catch(ApiException e) {
			throw new ApiException(env.getProperty("obrigatorios.inserir.aluno"));
		}
		return response;
	}

	public String removerAluno(Long idAluno) {
		String response = null;
		try {
			alunoRepository.deleteById(idAluno);
			response = env.getProperty("aluno.removido.sucesso");
		} catch (ApiException e) {
			throw new ApiException(env.getProperty("erro.id"));
		}
		return response;

	}

}
