package br.ufc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Papel;
import br.ufc.model.Usuario;

public class DummyDB {
	
	private int totalCountries;
	private String data = "Afghanistan,	Albania, Zimbabwe, hutie, xut";
	private List<String> countries;
	
	public List<String> getData(String query) {
		List<Usuario> news = new ArrayList<Usuario>();
		List<Papel> p = new ArrayList<Papel>();
		Papel px = new Papel();
		p.add(px);
				
		news.add(new Usuario("r", "r", "Silvio", p));
		news.add(new Usuario("r", "r", "Savio", p));
		news.add(new Usuario("r", "r", "bambo", p));
		
		//news = uDAO.listar();
		for(Usuario u: news){
			data += ", "+u.getNome();
		}
		
		countries = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(data, ",");
		
		while(st.hasMoreTokens()) {
			countries.add(st.nextToken().trim());
		}
		totalCountries = countries.size();
		
		
		String country = null;
		query = query.toLowerCase();
		List<String> matched = new ArrayList<String>();
		for(int i=0; i<totalCountries; i++) {
			country = countries.get(i).toLowerCase();
			if(country.startsWith(query)) {
				matched.add(countries.get(i));
			}
		}
		return matched;
	}
}