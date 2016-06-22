package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Aluno;

@Repository
public class AlunoDAOHib implements IAlunoDAO{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void inserir(Aluno aluno) {
		manager.persist(aluno);		
	}

	@Override
	public void alterar(Aluno aluno) {
		manager.merge(aluno);
	}

	@Override
	public Aluno recuperar(Long id) {
		return manager.find(Aluno.class, id);
	}

	@Override
	public void apagar(Long id) {
		Aluno ref = this.recuperar(id);
		if(ref!=null){
			manager.remove(ref);
		}
	}

	@Override
	public List<Aluno> listar() {
		return manager.createQuery("select a from aluno as a",
									Aluno.class).getResultList();
	}

	@Override
	public Aluno recuperar(String login) {
		
		String hql = "select a from aluno as a "
					+"where a.login = :param_login";
		
		Query query = manager.createQuery(hql);
		List<Aluno> alunos = 
				query.setParameter("param_login", login).getResultList();
		
		if(alunos.size()!=0){
			return alunos.get(0);
		}
		
		return null;
	}

}
















