package br.ufc.controller;

import java.util.List;

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

import br.ufc.dao.ClassificadoDAO;
import br.ufc.dao.NotificacaoDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.dao.OfertaDAO;
import br.ufc.model.Classificado;
import br.ufc.model.Notificacao;
import br.ufc.model.Oferta;
import br.ufc.model.Papel;
import br.ufc.model.Usuario;

@Transactional
@Controller
public class ClassificadoController {
	
	@Autowired
	@Qualifier(value="classificadoDAO")
	private ClassificadoDAO clDAO;
	
	@Autowired
	@Qualifier(value="usuarioDAO")
	private UsuarioDAO uDAO;
	
	@Autowired
	@Qualifier(value="ofertaDAO")
	private OfertaDAO oDAO;
	
	@Autowired
	@Qualifier(value="notificacaoDAO")
	private NotificacaoDAO ntDAO;
	
	@RequestMapping("/inserirClassificadoFormulario")
	public String inserirClassificadoFormulario(Model model, HttpSession session){
		
		if(session.getAttribute("usuario_logado") != null){
			Usuario usuario = uDAO.recuperar(((Usuario) session.getAttribute("usuario_logado")).getId());
			
			Long notificacoes = this.ntDAO.novasNotificacoes(usuario.getId());
			model.addAttribute("notificacoes", notificacoes);
		}
		
		return "classificado/inserir_classificado_formulario";
	}
	
	@RequestMapping("/inserirClassifcado")
	public String inserirClassifcado(Long idUsuario, @Valid Classificado classificado, HttpServletRequest req,
							   BindingResult result){
		if(result.hasFieldErrors("nome")){
			return "classificado/inserir_classificado_formulario";
		}
		
		Usuario autor = uDAO.recuperar(idUsuario);
		List<Papel> ps = autor.getPapelList();
		for (Papel papel : ps) {
			if((papel.getId() == 3) || (papel.getId() == 4)){
				classificado.setAtivo(true);
			}
		}
		
		classificado.setAutor(autor);
		this.clDAO.inserir(classificado);
		
		return "classificado/classificado_inserido_ok";
	}

	@RequestMapping("/listarClassificados")
	public String listarClassificados(Model model, HttpSession session){
		List<Classificado> classificados = this.clDAO.listar();
		if(session.getAttribute("usuario_logado") != null){
			Usuario usuario = uDAO.recuperar(((Usuario) session.getAttribute("usuario_logado")).getId());
			
			Long notificacoes = this.ntDAO.novasNotificacoes(usuario.getId());
			model.addAttribute("notificacoes", notificacoes);
		}
		
		model.addAttribute("classificados", classificados);
		return "classificado/listar_classificados";
	}
	
	@RequestMapping("fazerOfertaFormulario")
	public String fazerOfertaFormulario(Classificado classificado, Model model, HttpSession session){
		
		if(session.getAttribute("usuario_logado") != null){
			Usuario usuario = uDAO.recuperar(((Usuario) session.getAttribute("usuario_logado")).getId());
			
			Long notificacoes = this.ntDAO.novasNotificacoes(usuario.getId());
			model.addAttribute("notificacoes", notificacoes);
		}
		model.addAttribute("classificado", classificado);
		return "classificado/inserir_oferta";
	}
	
	@RequestMapping("/fazerOferta")
	public String fazerOferta(Long idUsuario, Oferta oferta, HttpServletRequest req){
			Classificado aux = clDAO.recuperar((long) Integer.parseInt(req.getParameter("idClassificado")));
			
			Usuario autor = uDAO.recuperar(idUsuario);
			
			oferta.setUsuario(autor);
			oDAO.inserir(oferta);
			if(aux.getMelhorOferta() != null){
				if((aux.getMelhorOferta().getId_oferta() < oferta.getPreco()))
					aux.setMelhorOferta(oferta);
			}else
				aux.setMelhorOferta(oferta);
			
			oferta.setClassificado(aux);
			oDAO.alterar(oferta);
			aux.setMelhorOferta(oferta);
			clDAO.alterar(aux);
			
			if(oferta.verificavencimento(oferta.getData(), oferta.getClassificado().getData())){
				System.out.println("ainda da para comprar");
			}else{
				System.out.println("Não da para comprar");
			}
			return "redirect:listarClassificados";
		
			
	}
	@RequestMapping("/listarClassificadosInativos")
	public String listarClassificadosInativos(Model model, HttpSession session){
		if(session.getAttribute("usuario_logado") != null){
			Usuario usuario = uDAO.recuperar(((Usuario) session.getAttribute("usuario_logado")).getId());
			
			Long notificacoes = this.ntDAO.novasNotificacoes(usuario.getId());
			model.addAttribute("notificacoes", notificacoes);
		}
		List<Classificado> classificados = this.clDAO.listar();
		model.addAttribute("classificados", classificados);
		return "classificado/listar_classificados_inativos";
	}
	
	@RequestMapping("/ativarClassificado")
	public String ativarClassificado(Long id){
		Classificado classificado = clDAO.recuperar(id);
		classificado.setAtivo(true);
		Notificacao note = new Notificacao(classificado.getAutor(), "Seu classificado foi aprovado!");
		ntDAO.inserir(note);
		clDAO.alterar(classificado);
		return "redirect:listarClassificadosInativos";
	}
	
	@RequestMapping("apagarClassificado")
	public String apagarClassificado(Long id){
		Classificado classificado = clDAO.recuperar(id);
		if(classificado.getAtivo() == true){
			clDAO.apagar(id);
			return "redirect:listarClassificados";
		}else{
			clDAO.apagar(id);
			Notificacao note = new Notificacao(classificado.getAutor(), "Seu classificado foi Recusado!");
			ntDAO.inserir(note);
			return "redirect:listarClassificadosInativos";
			
		}
		
	}
	
}
