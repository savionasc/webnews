package br.ufc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;




import javax.servlet.http.Cookie;

import org.springframework.stereotype.Repository;

import br.ufc.model.Usuario;

@Repository
public class UsuarioDAO{
	@PersistenceContext
	private EntityManager manager;


	public void inserir(Usuario usuario) {
		// TODO Auto-generated method stub
		manager.persist(usuario);
	}

	public void alterar(Usuario usuario) {
		// TODO Auto-generated method stub
		manager.merge(usuario);
	}

	public Usuario recuperar(Long id) {
		// TODO Auto-generated method stub
		System.out.println("id: "+id);
		return manager.find(Usuario.class, id);
	}
	public Cookie recuperaUsuarioPorCookie(Cookie[] cooks){
		for (Cookie cookie : cooks) {
			if(cookie.getName().equals("Orbita"))
				return cookie;	
		}
		return null;
	}
	public Usuario recuperar(String login) {
		// TODO Auto-generated method stub
		String hql = "select u from usuario as u "
				+"where u.login = :param_login";
	
		Query query = manager.createQuery(hql);
		List<Usuario> usuarios = 
				query.setParameter("param_login", login).getResultList();
		
		if(usuarios.size()!=0){
			return usuarios.get(0);
		}

		return null;
	}
	
	public void apagar(Long id) {
		// TODO Auto-generated method stub
		Usuario aux = this.recuperar(id);
		
		if(aux != null){
			manager.remove(aux);
		}
		
	}

	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return manager.createQuery("Select u from usuario as u",
				Usuario.class).getResultList();
	}
	
	public List<String> listarNomes() {
		// TODO Auto-generated method stub
		
		List<Usuario> users = manager.createQuery("Select u from usuario as u",
				Usuario.class).getResultList();
		
		List<String> userString = new ArrayList<String>();
		
		for (Usuario user : users) {
			userString.add(user.getNome());
		}
		return userString;
	}

	public Usuario recuperar(String usuario, boolean x) {
		// TODO Auto-generated method stub
		Long u = (long) Integer.parseInt(usuario);
		
		return manager.find(Usuario.class, u);

	}
	public List<Usuario> buscar(String texto) {
		// TODO Auto-generated method stub
		String hql = "select u from usuario as u "
				+"where u.nome like :param_texto";
	
		Query query = manager.createQuery(hql);
		List<Usuario> usuarios = 
				query.setParameter("param_texto", '%'+texto+'%').getResultList();
		return usuarios;
	}

}
