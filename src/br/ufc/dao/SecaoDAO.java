package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Classificado;
import br.ufc.model.Noticia;
import br.ufc.model.Secao;

@Repository
public class SecaoDAO {

	@PersistenceContext
	private EntityManager manager;

	public void inserir(Secao secao) {
		manager.persist(secao);	
	}
	
	public Secao recuperar(String secao) {
		Long s = (long) Integer.parseInt(secao);
		
		return manager.find(Secao.class, s);

	}
	
	public List<Secao> listar() {
		return manager.createQuery("select s from secao as s",
				Secao.class).getResultList();
	}

	public List<Noticia> recuperarNoticiasSecao(Secao secao) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String hql = "select s from secao as s "
						+"where s.id = :param_noticia";
				//System.out.println("Comentario:"+id);
				Query query = manager.createQuery(hql);
				List<Noticia> noticias = 
						query.setParameter("param_noticia", secao.getSecaoId()).getResultList();
				
				if(noticias.size()!=0){
					return noticias;
				}

				return null;
	}
	public Secao recuperar(Long id) {
		String hql = "select s from secao as s "
				+"where s.secaoId = :param_secao";
		Query query = manager.createQuery(hql);
		List<Secao> secao = 
				query.setParameter("param_secao", id).getResultList();
		
		if(secao.size()!=0){
			return secao.get(0);
		}
		return null;
	}
	
}
