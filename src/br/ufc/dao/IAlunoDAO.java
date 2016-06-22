package br.ufc.dao;

import java.util.List;

import br.ufc.model.Aluno;

public interface IAlunoDAO {

	public void inserir(Aluno aluno);
	public void alterar(Aluno aluno);
	public Aluno recuperar(Long id);
	public Aluno recuperar(String login);
	public void apagar(Long id);
	public List<Aluno> listar();
}
