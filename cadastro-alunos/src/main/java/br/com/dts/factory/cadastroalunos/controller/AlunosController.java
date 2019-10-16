package br.com.dts.factory.cadastroalunos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.dts.factory.cadastroalunos.obj.AlunoRequest;
import br.com.dts.factory.cadastroalunos.obj.AlunoResponse;
import br.com.dts.factory.cadastroalunos.service.AlunoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class AlunosController {

	@Autowired
	private AlunoService alunosService;
	
	@ApiOperation(value = "Inserir Aluno", notes = "insere um novo aluno na base de dados")
	@ApiResponses({ @ApiResponse(code = 400, message = "Erro de validação de negócio"),
			@ApiResponse(code = 500, message = "Erro inesperado") })
	@RequestMapping(value = "/inserir/aluno", produces = { "application/json" }, method = RequestMethod.POST)
	public AlunoResponse inserirAluno(@RequestBody AlunoRequest alunoRequest) {
		return alunosService.inserirAluno(alunoRequest);
	}

	@ApiOperation(value = "Consultar aluno por id", notes = "conulta na base de dados de acordo com o id de aluno informado")
	@ApiResponses({ @ApiResponse(code = 400, message = "Erro de validação de negócio"),
			@ApiResponse(code = 500, message = "Erro inesperado") })
	@RequestMapping(value = "/consultar/id/aluno", produces = { "application/json" }, method = RequestMethod.POST)
	public AlunoResponse consultaAlunoPorId(@RequestBody AlunoRequest alunoRequest) {
		return alunosService.consultarAlunoId(alunoRequest.getId());
	}

	@ApiOperation(value = "Consultar Todos os alunos", notes = "busca todos os alunos registrados na base de dados")
	@ApiResponses({ @ApiResponse(code = 400, message = "Erro de validação de negócio"),
			@ApiResponse(code = 500, message = "Erro inesperado") })
	@RequestMapping(value = "/buscar/todos/aluno", produces = { "application/json" }, method = RequestMethod.GET)
	public List<AlunoResponse> consultaTodosAlunos() {
		return alunosService.consultarTodosAlunos();
	}

	@ApiOperation(value = "Remover aluno", notes = "Remove um aluno da base de acordo com os parametros informados 'nome' ou 'id' ")
	@ApiResponses({ @ApiResponse(code = 400, message = "Erro de validação de negócio"),
			@ApiResponse(code = 500, message = "Erro inesperado") })
	@RequestMapping(value = "/remover/aluno", produces = { "application/json" }, method = RequestMethod.DELETE)
	public String removerAluno(@RequestBody AlunoRequest alunoRequest) {
		String response = alunosService.removerAluno(alunoRequest.getId());
		return response;
	}

	
}
