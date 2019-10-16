package br.com.dts.factory.cadastroalunos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dts.factory.cadastroalunos.obj.AlunoRequest;
import br.com.dts.factory.cadastroalunos.obj.AlunoResponse;

@Service
public class AlunoServiceImpl implements AlunoService{
	
	@Autowired
	private AlunoServiceStubImpl alunoServiceStubImpl;

	@Override
	public List<AlunoResponse> consultarTodosAlunos() {
		// TODO Auto-generated method stub
		return alunoServiceStubImpl.consultarTodosAlunos();
	}

	@Override
	public AlunoResponse consultarAlunoId(Long idAluno) {
		// TODO Auto-generated method stub
		return alunoServiceStubImpl.consultarAlunoId(idAluno);
	}

	@Override
	public AlunoResponse inserirAluno(AlunoRequest alunoRequest) {
		// TODO Auto-generated method stub
		return alunoServiceStubImpl.inserirAluno(alunoRequest);
	}

	@Override
	public String removerAluno(Long idAluno) {
		// TODO Auto-generated method stub
		return alunoServiceStubImpl.removerAluno(idAluno);
	}

	
}
