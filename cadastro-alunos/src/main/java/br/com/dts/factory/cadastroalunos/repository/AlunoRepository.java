package br.com.dts.factory.cadastroalunos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dts.factory.cadastroalunos.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}
