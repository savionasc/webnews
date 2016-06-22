package br.ufc.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Oferta;

@Repository
public class OfertaDAO {

	@PersistenceContext
	EntityManager manager;
	
	public void inserir(Oferta oferta){
		manager.persist(oferta);
	}
	
	public void alterar(Oferta oferta){
		manager.merge(oferta);
	}
}
