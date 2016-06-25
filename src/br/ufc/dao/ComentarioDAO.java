package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Comentario;
import br.ufc.model.Noticia;

@Repository
public class ComentarioDAO{
	
	@PersistenceContext
	private EntityManager manager;

	public void inserir(Comentario comentario) {
		// TODO Auto-generated method stub
		manager.persist(comentario);
	}

	public List<Comentario> listar() {
		// TODO Auto-generated method stub
		return manager.createQuery("select c from comentario as c",
				Comentario.class).getResultList();
	}
	public List<Comentario> recuperarComentarios(Noticia idNoticia) {
		// TODO Auto-generated method stub
		String hql = "select c from comentario as c "
				+"where c.noticia = :param_noticia";
		System.out.println("noticia:"+idNoticia);
		Query query = manager.createQuery(hql);
		List<Comentario> comentarios = 
				query.setParameter("param_noticia", idNoticia).getResultList();
		
		if(comentarios.size()!=0){
			return comentarios;
		}

		return null;
	}
	
	public Comentario recuperar(Long id) {
		// TODO Auto-generated method stub
		String hql = "select c from comentario as c "
				+"where c.comentarioId = :param_comentario";
		System.out.println("Comentario:"+id);
		Query query = manager.createQuery(hql);
		List<Comentario> comentario = 
				query.setParameter("param_comentario", id).getResultList();
		
		if(comentario.size()!=0){
			return comentario.get(0);
		}

		return null;
	}
	public void apagar(Long id) {
		Comentario ref = this.recuperar(id);
		if(ref!=null){
			manager.remove(ref);
			System.out.println(ref.getTexto()+ref.getAutor());
		}
	}
}