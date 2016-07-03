package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Favorito;
import br.ufc.model.Noticia;
import br.ufc.model.Notificacao;
import br.ufc.model.Usuario;

@Repository
public class NotificacaoDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Notificacao notificacao) {
		// TODO Auto-generated method stub
		manager.persist(notificacao);
	}
	public Long novasNotificacoes(Long idUsuario) {
		String hql = "select count(n) from notificacao as n WHERE lido = 0 and usuario_id = :param_id";
	
		Query query = manager.createQuery(hql);
		Long notificacoes = (long) query.setParameter("param_id", idUsuario).getSingleResult();
		if(notificacoes != 0){
			return notificacoes;
		}
		return null;
	}
	
	public List<Notificacao> listar(Usuario id) {
		// TODO Auto-generated method stub
		String hql = "select n from notificacao as n "
				+"where lido = 0 and n.usuario = :param_favorito";
		Query query = manager.createQuery(hql);
		return query.setParameter("param_favorito", id).getResultList();
	}
	
	public Notificacao recuperar(Long id) {
		// TODO Auto-generated method stub
		String hql = "select n from notificacao as n "
				+"where n.id = :param_notificacao";
		Query query = manager.createQuery(hql);
		List<Notificacao> notificacoes = 
				query.setParameter("param_notificacao", id).getResultList();
		
		if(notificacoes.size()!=0){
			return notificacoes.get(0);
		}

		return null;
	}
	
	public void apagar(Long id) {
		Notificacao ref = this.recuperar(id);
		if(ref!=null){
			manager.remove(ref);
		}
	}
	public void visualizar(Long id) {
		// TODO Auto-generated method stub
		Notificacao n = recuperar(id);
		n.setLido(true);
		manager.merge(n);
	}
}
