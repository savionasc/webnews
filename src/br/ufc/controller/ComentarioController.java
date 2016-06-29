package br.ufc.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest; 
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.ComentarioDAO;
import br.ufc.dao.NoticiaDAO;
import br.ufc.dao.SecaoDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Comentario;
import br.ufc.model.Noticia;
import br.ufc.model.Secao;
import br.ufc.model.Usuario;
import br.ufc.util.Emot;

@Transactional
@Controller
public class ComentarioController {

	@Autowired
	@Qualifier(value="comentarioDAO")
	ComentarioDAO cDAO;
	
	@Autowired
	@Qualifier(value="usuarioDAO")
	UsuarioDAO uDAO;
	
	@Autowired
	@Qualifier(value="noticiaDAO")
	NoticiaDAO nDAO;
	
	@Autowired
	@Qualifier(value="secaoDAO")
	SecaoDAO sDAO;
	
	
	@RequestMapping("/inserirComentario")
	public String inserirComentario(@Valid Comentario comentario, HttpServletRequest req,
							   BindingResult result){
		
		if(result.hasFieldErrors("nome")){
			return "redirect:/listarComentarios?id="+comentario.getNoticia().getNoticiaId();
		}
		Noticia noticia = nDAO.recuperar((long) Integer.parseInt(req.getParameter("idNoticia")));
		comentario.setNoticia(noticia);
		
		Usuario autor = uDAO.recuperar((long) Integer.parseInt(req.getParameter("idUsuario")));
		
		comentario.setAutor(autor);
		
		Emot e = new Emot();
		comentario.setTexto(e.inserir(comentario.getTexto()));
		
		this.cDAO.inserir(comentario);
		
		return "redirect:/listarComentarios?id="+noticia.getNoticiaId();
	}
	@RequestMapping("/listarComentarios")
	public String listarComentarios(Long id, Model model){
		Noticia noticia = nDAO.recuperar(id);
		noticia.setAcesso(noticia.getAcesso()+1);
		List<Secao> secoes = this.sDAO.listar();
		model.addAttribute("secoes", secoes);
		List<Comentario> comentario = cDAO.recuperarComentarios(noticia);
		model.addAttribute("comentarios", comentario);
		model.addAttribute("noticia", noticia);
		return "noticia/verNoticia";
	}
	@RequestMapping("/apagarComentario")
	public String apagarComentario(Long id, HttpServletRequest req){
		Comentario c = cDAO.recuperar(id);
		Noticia noticia = c.getNoticia();
		this.cDAO.apagar(id);			
		
		return "redirect:/listarComentarios?id="+noticia.getNoticiaId();
	}
}
