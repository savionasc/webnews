package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Favorito;

@Repository
public class FavoritoDAO {

	@PersistenceContext
	EntityManager manager;
	
	public void inserir(Favorito favorito){
		if(recuperar(favorito.getId()) != null){
			
		}
		manager.persist(favorito);
	}
	
	public void alterar(Favorito favorito){
		manager.merge(favorito);
	}
	
	public List<Favorito> listar() {
		// TODO Auto-generated method stub
		return manager.createQuery("select f from favorito as f",
				Favorito.class).getResultList();
	}
	
	public Favorito recuperar(Long id) {
		// TODO Auto-generated method stub
		String hql = "select f from favorito as f "
				+"where f.id = :param_favorito";
		Query query = manager.createQuery(hql);
		List<Favorito> favoritos = 
				query.setParameter("param_favorito", id).getResultList();
		
		if(favoritos.size()!=0){
			return favoritos.get(0);
		}

		return null;
	}
	
	public void apagar(Long id) {
		Favorito ref = this.recuperar(id);
		if(ref!=null){
			manager.remove(ref);
		}
	}
}
