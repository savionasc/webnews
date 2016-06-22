package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Papel;

@Repository
public class PapelDAO {
	@PersistenceContext
	private EntityManager manager;

	public void inserir(Papel papel) {
		// TODO Auto-generated method stub
		manager.persist(papel);
	}
	public Papel recuperar(Long papel) {
		
		String hql = "select p from papel as p "
					+"where p.id = :param_papel";
		
		Query query = manager.createQuery(hql);
		List<Papel> papeis = 
				query.setParameter("param_papel", papel).getResultList();
		
		if(papeis.size()!=0){
			return papeis.get(0);
		}
		
		return null;
	}
	public List<Papel> listar() {
		return manager.createQuery("Select p from papel as p",
				Papel.class).getResultList();
	}
	
	public Papel recuperarPU(Long idUser) {
		
		String hql = "select p from papel_usuario as p "
					+"where p.USUARIO_ID = :param_idUser";
		
		Query query = manager.createQuery(hql);
		List<Papel> papeis = 
				query.setParameter("param_idUser", idUser).getResultList();
		
		if(papeis.size()!=0){
			return papeis.get(0);
		}
		
		return null;
	}
}
