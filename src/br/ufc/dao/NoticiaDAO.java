package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Comentario;
import br.ufc.model.Noticia;

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
				+"where n.noticiaId = :param_id";
	
		Query query = manager.createQuery(hql);
		List<Noticia> noticias = 
				query.setParameter("param_id", id).getResultList();
		
		if(noticias.size()!=0){
			return noticias.get(0);
		}
		return null;
	}
	
	public List<Comentario> recuperarComentarios(){
		/*String hql = "select c from comentario as c "
				+"where c.COMENTARIO_ID = :param_id";
	
		Query query = manager.createQuery(hql);
		List<Comentario> papeis = 
				query.setParameter("param_id", id).getResultList();
		
		if(papeis.size()!=0){
			return papeis.get(0);
		}

		*/
		return null;
	}

	public List<Noticia> listar() {
		// TODO Auto-generated method stub
		return manager.createQuery("select n from noticia as n",
				Noticia.class).getResultList();
	}
	public Noticia recuperarId(Long id) {
		return manager.find(Noticia.class, id);
	}
	public void apagar(Long id) {
		Noticia aux = recuperarId(id);
		if(aux != null){
			System.out.println("Remover:"+aux.getTitulo()+" "+aux.getTexto());
			manager.remove(aux);
			
		}
		
	}
	public List<Noticia> buscar(String texto) {
		// TODO Auto-generated method stub
		String hql = "select n from noticia as n "
				+"where n.texto like :param_texto";
	
		Query query = manager.createQuery(hql);
		List<Noticia> noticias = 
				query.setParameter("param_texto", '%'+texto+'%').getResultList();
		return noticias;
	}
}
