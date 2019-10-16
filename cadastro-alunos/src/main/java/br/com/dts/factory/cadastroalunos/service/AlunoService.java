package br.com.dts.factory.cadastroalunos.service;

import java.util.List;

import br.com.dts.factory.cadastroalunos.obj.AlunoRequest;
import br.com.dts.factory.cadastroalunos.obj.AlunoResponse;

public interface AlunoService {

	public List<AlunoResponse> consultarTodosAlunos();
	
	public AlunoResponse consultarAlunoId(Long idAluno);
	
	public AlunoResponse inserirAluno(AlunoRequest alunoRequest);
	
	public String removerAluno(Long idAluno);
}
