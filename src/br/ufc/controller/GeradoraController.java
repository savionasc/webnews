package br.ufc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.PapelDAO;
import br.ufc.dao.SecaoDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Papel;
import br.ufc.model.Secao;
import br.ufc.model.Usuario;

@Transactional
@Controller
public class GeradoraController {
	
	@Autowired
	@Qualifier(value="usuarioDAO")
	private UsuarioDAO uDAO;
	
	@Autowired
	@Qualifier(value="papelDAO")
	private PapelDAO pDAO;
	
	@Autowired
	@Qualifier(value="secaoDAO")
	private SecaoDAO sDAO;
	
	@RequestMapping("/construirEstrutura")
	public String construirEstrutura(){
		criarPapeis();
		criarADM();
		criarSecoes();
		return "redirect:home";
	}
	
	public void criarPapeis(){
		List<Papel> p = pDAO.listar();
		if(p.size() == 0){
			pDAO.inserir(new Papel("Leitor"));
			pDAO.inserir(new Papel("Jornalista"));
			pDAO.inserir(new Papel("Editor"));
			pDAO.inserir(new Papel("ADM"));
			System.out.println("Papeis criados com sucesso!");
		}
	}
	
	public void criarADM(){
		List<Usuario> u = uDAO.listar();
		List<Papel> p = pDAO.listar();
		if(u.size() == 0){
			//uDAO.inserir(new Usuario("AdM123", "SeNhA123", "ADM", p));
			uDAO.inserir(new Usuario("a", "a", "ADM", p));
			System.out.println("Usuarios cadastrados com sucesso!");
		}
	}
	
	public void criarSecoes(){
		List<Secao> s = sDAO.listar();
		if(s.size() == 0){
			sDAO.inserir(new Secao("Esportes", "Aqui você ver todas as atualidades de esportes."));
			sDAO.inserir(new Secao("Culinaria", "Aqui você ver nas tecnicas de cozinhar."));
			sDAO.inserir(new Secao("Politica", "Aqui você ver o de sempre, mas o que muda é a sua indignação."));
			System.out.println("Seções cadastradas com sucesso!");
		}
	}
}
