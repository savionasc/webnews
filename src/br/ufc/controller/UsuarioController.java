package br.ufc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.ufc.dao.NotificacaoDAO;
import br.ufc.dao.PapelDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Papel;
import br.ufc.model.Usuario;
import br.ufc.util.AulaFileUtil;

@Transactional
@Controller
public class UsuarioController {
	
	@Autowired
	@Qualifier(value="usuarioDAO")
	private UsuarioDAO uDAO;
	
	@Autowired
	@Qualifier(value="papelDAO")
	private PapelDAO pDAO;
	
	@Autowired
	@Qualifier(value="notificacaoDAO")
	private NotificacaoDAO ntDAO;
	
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping("/inserirUsuarioFormulario")
	public String inserirUsuarioFormulario(Model model, HttpSession session){
		if(session.getAttribute("usuario_logado") != null){
			Usuario usuario = uDAO.recuperar(((Usuario) session.getAttribute("usuario_logado")).getId());
			
			Long notificacoes = this.ntDAO.novasNotificacoes(usuario.getId());
			model.addAttribute("notificacoes", notificacoes);
			model.addAttribute("tam", usuario.getPapelList().size());
		}
		
		List<Papel> papeis = this.pDAO.listar();
		papeis.remove(3);
		model.addAttribute("papeis", papeis);
		
		
		return "usuario/inserir_usuario_papel";
	}
	
	@RequestMapping("/inserirUsuario")
	public String inserirUsuario(@Valid Usuario usuario, HttpServletRequest req,
							   BindingResult result, @RequestParam(value="imagem", required=false) MultipartFile imagem){
		
		if(result.hasFieldErrors("nome")){
			return "usuario/inserir_usuario_papel";
		}
		
		List<Papel> p = new ArrayList<Papel>();
		
		p.add(this.pDAO.recuperar((long) Integer.parseInt(req.getParameter("papel"))));
		//p.add(pDAO.recuperar(1l));
		usuario.setPapelList(p);
		this.uDAO.inserir(usuario);
		System.out.println(usuario.getLogin()+usuario.getId()+p.get(0));
		
		String path = servletContext.getRealPath("/")+"resources/usr_imgs/"+usuario.getId()+".png";
		
		if(imagem.getOriginalFilename().equals("")){
			//System.out.println("Ele nao subiu imagem");
			usuario.setImgEstado(false);
		}else{
			//System.out.println("Ele subiu imagem");
			//usuario.setImagemLink(""+usuario.getId());
			usuario.setImgEstado(true);
			AulaFileUtil.salvarImagem(path, imagem);
			
		}
		
		return "usuario/usuario_inserido_ok";
	}
	
	@RequestMapping("/listarUsuario")
	public String listarUsuario(Model model, HttpSession session){
		
		if(session.getAttribute("usuario_logado") != null){
			Usuario usuario = uDAO.recuperar(((Usuario) session.getAttribute("usuario_logado")).getId());
			
			Long notificacoes = this.ntDAO.novasNotificacoes(usuario.getId());
			model.addAttribute("notificacoes", notificacoes);
		}
		
		List<Usuario> usuarios = this.uDAO.listar();
		model.addAttribute("usuarios", usuarios);
		
		
		return "usuario/listar_usuario";
	}	
	
	@RequestMapping("/apagarUsuario")
	public String apagarUsuario(Long id){
		
		this.uDAO.apagar(id);
		return "redirect:listarUsuario";
	}
	
	@RequestMapping("/alterarUsuarioFormulario")
	public String alterarUsuarioFormulario(Long id, Model model){
		List<Papel> papeis = this.pDAO.listar();
		model.addAttribute("papeis", papeis);
		Usuario usuario = this.uDAO.recuperar(id);
		model.addAttribute("usuario", usuario);
		return "usuario/alterar_usuario_formulario";
	}
	
	@RequestMapping("/alterarUsuario")
	public String alterarUsuario(Usuario usuario, HttpServletRequest req){
		List<Papel> p = new ArrayList<Papel>();
		
		p.add(this.pDAO.recuperar((long) Integer.parseInt(req.getParameter("papel"))));
		//System.out.println("papel"+(p.get(0).getPapel()));
		usuario.setPapelList(p);
		this.uDAO.alterar(usuario);
		return "redirect:listarUsuario";
	}
	
}
