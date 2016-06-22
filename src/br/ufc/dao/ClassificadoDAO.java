package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Classificado;
import br.ufc.model.Comentario;
import br.ufc.model.Noticia;
import br.ufc.model.Oferta;

@Repository
public class ClassificadoDAO {

	
	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Classificado classificado) {
		// TODO Auto-generated method stub
		manager.persist(classificado);
	}
	
	public void alterar(Classificado classificado){
		manager.merge(classificado);
	}
	
	public Classificado recuperar(Long id) {
		// TODO Auto-generated method stub
		String hql = "select c from classificado as c "
				+"where c.id = :param_comentario";
		//System.out.println("Comentario:"+id);
		Query query = manager.createQuery(hql);
		List<Classificado> classificado = 
				query.setParameter("param_comentario", id).getResultList();
		
		if(classificado.size()!=0){
			return classificado.get(0);
		}

		return null;
	}
	
	public List<Classificado> listar() {
		// TODO Auto-generated method stub
		return manager.createQuery("select c from classificado as c",
				Classificado.class).getResultList();
	}
	public void apagar(Long id) {
		Classificado ref = this.recuperar(id);
		if(ref!=null){
			manager.remove(ref);
		}
	}
}
