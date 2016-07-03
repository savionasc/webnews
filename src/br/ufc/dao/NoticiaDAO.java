package br.ufc.dao;

import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Favorito;
import br.ufc.model.Noticia;
import br.ufc.model.Secao;

@Repository
public class NoticiaDAO{
	@PersistenceContext
	private EntityManager manager;


	public void inserir(Noticia noticia) {
		// TODO Auto-generated method stub
		manager.persist(noticia);
	}
	
	public void alterar(Noticia noticia){
		manager.merge(noticia);
	}

	public Noticia recuperar(Long id) {
		// TODO Auto-generated method stub
		String hql = "select n from noticia as n "
				+"where n.noticiaId = :param_id and inativo = 0";
	
		Query query = manager.createQuery(hql);
		List<Noticia> noticias = 
				query.setParameter("param_id", id).getResultList();
		
		if(noticias.size()!=0){
			return noticias.get(0);
		}
		return null;
	}

	public List<Noticia> listar() {
		// TODO Auto-generated method stub
		return manager.createQuery("select n from noticia as n where inativo = 0",
				Noticia.class).getResultList();
	}
	
	public List<Noticia> listarPorRegiao(Locale local) {
		// TODO Auto-generated method stub
		String hql = "select n from noticia as n "
				+"where n.locale = :param_local and inativo = 0";
	
		Query query = manager.createQuery(hql);
		List<Noticia> noticias = 
				query.setParameter("param_local", local).getResultList();
		return noticias;
	}
	public List<Noticia> listar6MaisAcessadas() {
		// TODO Auto-generated method stub
		List<Noticia> noticias = manager.createQuery("select n from noticia as n where inativo = 0 order by acesso desc",
				Noticia.class).getResultList();
		if(noticias.size() > 0){
			if(noticias.size() < 6){
				return noticias.subList(0, noticias.size());
			}
			return noticias.subList(0, 6);
		}
		
		return null;
		
	}
	
	public List<Noticia> listar6MaisRecentes(Secao secao) {
		// TODO Auto-generated method stub
		
		String hql = "select n from noticia as n where n.secao = :param_id and inativo = 0 order by n.noticiaId desc";
	
		Query query = manager.createQuery(hql);
		List<Noticia> noticias = 
				query.setParameter("param_id", secao).getResultList();

		if(noticias.size() > 0){
			
			if(noticias.size() < 6){
				return noticias.subList(0, noticias.size());
			}
			return noticias.subList(0, 6);
		}
		
		return null;
		
	}
	
	public Noticia recuperarId(Long id) {
		return manager.find(Noticia.class, id);
	}
	/*public void apagar(Long id) {
		Noticia aux = recuperarId(id);
		if(aux != null){
			System.out.println("Remover:"+aux.getTitulo()+" "+aux.getTexto());
			manager.remove(aux);
			
		}
		
	}*/
	
	public void desativar(Long id) {
		Noticia aux = recuperarId(id);
		if(aux != null){
			aux.setInativo(true);
			manager.merge(aux);
		}
		
	}
	
	public List<Noticia> buscar(String texto) {
		// TODO Auto-generated method stub
		String hql = "select n from noticia as n "
				+"where n.titulo like :param_texto";
	
		Query query = manager.createQuery(hql);
		List<Noticia> noticias = 
				query.setParameter("param_texto", '%'+texto+'%').getResultList();
		return noticias;
	}
}
