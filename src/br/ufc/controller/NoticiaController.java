package br.ufc.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
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
import br.ufc.dao.SecaoDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Favorito;
import br.ufc.model.Noticia;
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
	private ServletContext servletContext;

	
	@RequestMapping("/inserirNoticiaFormulario")
	public String inserirNoticiaFormulario(Model model){
		List<Secao> secoes = this.sDAO.listar();
		model.addAttribute("secoes", secoes);
		//List<Usuario> usuarios = this.uDAO.listar();
		//model.addAttribute("usuarios", usuarios);
		return "noticia/inserir_noticia_formulario";
	}
	
	@RequestMapping("/inserirNoticia")
	public String inserirNoticia(@Valid Noticia noticia, HttpServletRequest req,
							   BindingResult result, @RequestParam(value="imagem", required=false) MultipartFile imagem){
		//JOptionPane.showMessageDialog(null, "ENTROU!!!");
		if(result.hasFieldErrors("nome")){
			return "noticia/inserir_noticia_formulario";
		}
		
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
	public String listarNoticia(Model model){
		List<Noticia> noticias = this.nDAO.listar();
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
		this.nDAO.apagar(id);
		return "redirect:listarNoticia";
	}
	
	@RequestMapping("buscarFormularioNoticias")
	public String buscarFormularioNoticias(){
		return "noticia/buscar_formulario_noticia";
	}
	@RequestMapping("buscarNoticias")
	public String buscarNoticias(String texto, Model model){
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
	public String alterarNoticia(Noticia noticia, Long seccao, Long idAutor, HttpServletRequest req){
		noticia.setAutor(uDAO.recuperar(idAutor));
		noticia.setSecao(sDAO.recuperar(seccao));
		nDAO.alterar(noticia);
		return "redirect:listarNoticia";
	}
	
	@RequestMapping("/verFavoritos")
	public String verFavoritos(Long idUsuario, Model model){
		List<Favorito> favoritos = this.fDAO.listar();
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
		return "redirect:verFavoritos";
	}
}
