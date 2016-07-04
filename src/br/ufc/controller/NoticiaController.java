package br.ufc.controller;

import java.util.List;
import java.util.Locale;

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

import br.ufc.dao.FavoritoDAO;
import br.ufc.dao.NoticiaDAO;
import br.ufc.dao.NotificacaoDAO;
import br.ufc.dao.SecaoDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Favorito;
import br.ufc.model.Noticia;
import br.ufc.model.Notificacao;
import br.ufc.model.Secao;
import br.ufc.model.Usuario;
import br.ufc.util.AulaFileUtil;

@Transactional
@Controller
public class NoticiaController {
	@Autowired
	@Qualifier(value="noticiaDAO")
	private NoticiaDAO nDAO;
	
	@Autowired
	@Qualifier(value="usuarioDAO")
	private UsuarioDAO uDAO;
	
	@Autowired
	@Qualifier(value="secaoDAO")
	private SecaoDAO sDAO;
	
	@Autowired
	@Qualifier(value="favoritoDAO")
	private FavoritoDAO fDAO;
	
	@Autowired
	@Qualifier(value="notificacaoDAO")
	private NotificacaoDAO ntDAO;
	
	@Autowired
	private ServletContext servletContext;

	
	@RequestMapping("/inserirNoticiaFormulario")
	public String inserirNoticiaFormulario(Model model, HttpSession session){
		if(session.getAttribute("usuario_logado") != null){
			Usuario usuario = uDAO.recuperar(((Usuario) session.getAttribute("usuario_logado")).getId());
			
			Long notificacoes = this.ntDAO.novasNotificacoes(usuario.getId());
			model.addAttribute("notificacoes", notificacoes);
		}
		List<Secao> secoes = this.sDAO.listar();
		model.addAttribute("secoes", secoes);
		return "noticia/inserir_noticia_formulario";
	}
	@RequestMapping("/resultados")
	public String resultados(Model model){
		List<Noticia> noticias = this.nDAO.listar();
		model.addAttribute("noticias", noticias);
		return "noticia/resultados_noticias";
	}
	
	@RequestMapping("/inserirNoticia")
	public String inserirNoticia(@Valid Noticia noticia, HttpServletRequest req,
							   BindingResult result, @RequestParam(value="imagem", required=false) MultipartFile imagem){
		if(result.hasFieldErrors("nome")){
			return "noticia/inserir_noticia_formulario";
		}
		String language = req.getParameter("lingua");
        Locale locale = new Locale(language);
		
        noticia.setLocale(locale);
		Secao secao = sDAO.recuperar(req.getParameter("secaoValores"));
		noticia.setSecao(secao);
		Usuario autor = uDAO.recuperar((long) Integer.parseInt(req.getParameter("usuario")));
		noticia.setAutor(autor);
		this.nDAO.inserir(noticia);
		
		String path = servletContext.getRealPath("/")+"resources/images/"+noticia.getNoticiaId()+".png";
		
		if(!imagem.getOriginalFilename().equals("")){
			AulaFileUtil.salvarImagem(path, imagem);	
		}
		
		return "noticia/noticia_inserido_ok";
	}
	
	
	@RequestMapping("/listarNoticia")
	public String listarNoticia(Model model, HttpServletRequest req, HttpSession session){
		if(session.getAttribute("usuario_logado") != null){
			Usuario usuario = uDAO.recuperar(((Usuario) session.getAttribute("usuario_logado")).getId());
			
			Long notificacoes = this.ntDAO.novasNotificacoes(usuario.getId());
			model.addAttribute("notificacoes", notificacoes);
		}
		
		String language = req.getParameter("l");
        Locale local = new Locale(language);
		List<Noticia> noticias = this.nDAO.listarPorRegiao(local);
		model.addAttribute("noticias", noticias);
		
		return "noticia/listar_noticia";
	}
	
	@RequestMapping("/listarNoticiaPorSecao")
	public String listarNoticiaPorSecao(Long id, Model model){
		Secao secao = sDAO.recuperar(id);
		
		List<Noticia> noticias = secao.getNoticias();
		model.addAttribute("noticias", noticias);
		return "noticia/ver_noticia_por_secao";
	}
	@RequestMapping("/apagarNoticia")
	public String apagarNoticia(Long id){
		Noticia noticia = nDAO.recuperar(id);
		List<Favorito> favoritos = noticia.getFavoritos();
		Notificacao note;
		for (Favorito favorito : favoritos) {
			note = new Notificacao(favorito.getUsuario(), "Uma noticia que você favoritou foi apagada!");
			ntDAO.inserir(note);
			fDAO.apagar(favorito.getId());
		}
		this.nDAO.desativar(id);
		return "redirect:resultados";
	}
	
	@RequestMapping("buscarFormularioNoticias")
	public String buscarFormularioNoticias(Model model, HttpSession session){
		if(session.getAttribute("usuario_logado") != null){
			Usuario usuario = uDAO.recuperar(((Usuario) session.getAttribute("usuario_logado")).getId());
			
			Long notificacoes = this.ntDAO.novasNotificacoes(usuario.getId());
			model.addAttribute("notificacoes", notificacoes);
		}
		return "noticia/buscar_formulario_noticia";
	}
	@RequestMapping("buscarNoticias")
	public String buscarNoticias(String texto, Model model, HttpSession session){
		if(session.getAttribute("usuario_logado") != null){
			Usuario usuario = uDAO.recuperar(((Usuario) session.getAttribute("usuario_logado")).getId());
			
			Long notificacoes = this.ntDAO.novasNotificacoes(usuario.getId());
			model.addAttribute("notificacoes", notificacoes);
		}
		List<Noticia> noticias = nDAO.buscar(texto);
		model.addAttribute("noticias", noticias);
		return "noticia/listar_noticia";
	}
	@RequestMapping("/alterarNoticiaFormulario")
	public String alterarNoticiaFormulario(Long id, Model model){
		Noticia noticia = nDAO.recuperarId(id);
		List<Secao> secoes = sDAO.listar();
		model.addAttribute("secoes", secoes);
		model.addAttribute("noticia", noticia);
		return "noticia/alterar_noticia_formulario";
	}
	
	@RequestMapping("/alterarNoticia")
	public String alterarNoticia(Noticia noticia, Long seccao, Long idAutor){
		noticia.setAutor(uDAO.recuperar(idAutor));
		noticia.setSecao(sDAO.recuperar(seccao));
		Noticia noticia2 = nDAO.recuperar(noticia.getNoticiaId());
		List<Favorito> favoritos = noticia2.getFavoritos();
		Notificacao note;
		if(favoritos != null){
			for (Favorito favorito : favoritos) {
				note = new Notificacao(favorito.getUsuario(), "A <a href=listarComentarios?id="+noticia.getNoticiaId()+">noticia</a> foi alterada!");
				ntDAO.inserir(note);
			}
			
		}
		
		nDAO.alterar(noticia);
		return "redirect:resultados";
	}
	
	@RequestMapping("/verFavoritos")
	public String verFavoritos(Long u, Model model, HttpSession session){
		if(session.getAttribute("usuario_logado") != null){
			Usuario usuario = uDAO.recuperar(((Usuario) session.getAttribute("usuario_logado")).getId());
			
			Long notificacoes = this.ntDAO.novasNotificacoes(usuario.getId());
			model.addAttribute("notificacoes", notificacoes);
		}
		Usuario user = uDAO.recuperar(u);
		List<Favorito> favoritos = this.fDAO.listar(user);
		model.addAttribute("favoritos", favoritos);
		
		return "noticia/listar_favoritos";
	}
	
	@RequestMapping("adicionarFavorito")
	public String adicionarFavoritos(HttpServletRequest req){	
		Favorito favorito = new Favorito();
		Usuario autor = uDAO.recuperar((long) Integer.parseInt(req.getParameter("usuario")));
		Noticia noticia = nDAO.recuperar((long) Integer.parseInt(req.getParameter("noticia")));
		favorito.setNoticia(noticia);
		favorito.setUsuario(autor);
		fDAO.inserir(favorito);
		
		return "redirect:login";
	}
	
	@RequestMapping("removerFavorito")
	public String removerFavorito(Long id){
		fDAO.apagar(id);
		return "redirect:verFavoritos?u="+id;
	}
}
