package br.ufc.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.ufc.model.Aluno;

@Repository
public class AlunoDAOMem implements IAlunoDAO{

	private static List<Aluno> alunos = new ArrayList<Aluno>();
	private static Long counter = 0L;
	
	public void inserir(Aluno aluno){
		aluno.setId(counter);
		counter++;
		alunos.add(aluno);
	}
	
	public void alterar(Aluno aluno){
		int index = alunos.indexOf(aluno);
		if(index>=0){
			alunos.remove(index);
			alunos.add(index, aluno);
		}
	}
	
	public Aluno recuperar(Long id){
		
		Aluno dummy = new Aluno();
		dummy.setId(id);
		int index = alunos.indexOf(dummy);
		if(index>=0){
			return alunos.get(index);
		}
		
		return null;
	}
	
	public void apagar(Long id){
		Aluno dummy = new Aluno();
		dummy.setId(id);
		int index = alunos.indexOf(dummy);
		if(index>=0){
			alunos.remove(index);
		}
	}
	
	public List<Aluno> listar(){
		return alunos;
	}

	@Override
	public Aluno recuperar(String login) {
		// TODO Auto-generated method stub
		return null;
	}
}





