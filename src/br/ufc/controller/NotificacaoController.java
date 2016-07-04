package br.ufc.controller;

import java.util.List;

import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.NotificacaoDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Classificado;
import br.ufc.model.Noticia;
import br.ufc.model.Notificacao;
import br.ufc.model.Usuario;

@Transactional
@Controller
public class NotificacaoController {
	
	@Autowired
	@Qualifier(value="notificacaoDAO")
	private NotificacaoDAO ntDAO;
	
	@Autowired
	@Qualifier(value="usuarioDAO")
	private UsuarioDAO uDAO;
	
	@RequestMapping("/inserirNotificacaoFormulario")
	public String inserirNotificacaoFormulario(Model model){
		List<Usuario> usuarios = uDAO.listar();
		model.addAttribute("usuarios", usuarios);
		return "notificacao/inserir_notificacao";
	}
	
	@RequestMapping("/inserirNotificacao")
	public String inserirNotificacao(Long usuarios, Notificacao notificacao){
		Usuario usuario = uDAO.recuperar(usuarios);
		notificacao.setUsuario(usuario);
		ntDAO.inserir(notificacao);
		return "classificado/classificado_inserido_ok";
	}
	
	@RequestMapping("/listarNotificacoes")
	public String listarNotificacoes(Model model, HttpSession session){
		if(session.getAttribute("usuario_logado") != null){
			Usuario usuario = uDAO.recuperar(((Usuario) session.getAttribute("usuario_logado")).getId());
			
			Long notificacoes = this.ntDAO.novasNotificacoes(usuario.getId());
			model.addAttribute("notificacoes", notificacoes);
			List<Notificacao> notificacoesx = this.ntDAO.listar(usuario);
			model.addAttribute("notificacoesLista", notificacoesx);
		}
		return "notificacao/listar_notificacoes";
	}
	
	@RequestMapping("apagarNotificacao")
	public String apagarNotificacao(Long id){
		ntDAO.apagar(id);
		return "redirect:listarNotificacoes";
	}
	
	@RequestMapping("visualizarNotificacao")
	public String visualizarNotificacao(Long id){
		ntDAO.visualizar(id);
		return "redirect:listarNotificacoes";
	}
}
