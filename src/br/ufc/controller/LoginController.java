package br.ufc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.NoticiaDAO;
import br.ufc.dao.SecaoDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.dao.PapelDAO;
import br.ufc.model.Noticia;
import br.ufc.model.Papel;
import br.ufc.model.Secao;
import br.ufc.model.Usuario;

@Controller
public class LoginController {
	
	@Autowired
	@Qualifier(value="usuarioDAO")
	private UsuarioDAO uDAO;
	
	@Autowired
	@Qualifier(value="papelDAO")
	private PapelDAO pDAO;
	
	@Autowired
	@Qualifier(value="noticiaDAO")
	private NoticiaDAO nDAO;
	
	@Autowired
	@Qualifier(value="secaoDAO")
	private SecaoDAO sDAO;
	
	@RequestMapping("/loginFormulario")
	public String loginFormulario(){
		return "login_formulario";
	}
	@RequestMapping("/home")
	public String home(Model model){
		List<Noticia> noticias = this.nDAO.listar5MaisAcessadas();
		model.addAttribute("noticias", noticias);
		
		noticias = this.nDAO.listar5MaisRecentes(sDAO.recuperar(1l));
		model.addAttribute("noticias1", noticias);
		
		noticias = this.nDAO.listar5MaisRecentes(sDAO.recuperar(2l));
		model.addAttribute("noticias2", noticias);
		
		noticias = this.nDAO.listar5MaisRecentes(sDAO.recuperar(3l));
		model.addAttribute("noticias3", noticias);
		
		return "index";
	}
	
	@RequestMapping("/login")
	public String login(boolean permanecer, Usuario usuario, HttpServletRequest request,HttpSession session, Model model, HttpServletResponse response){
		if(session.getAttribute("usuario_logado") == null){
			Cookie[] cooks = request.getCookies();		
			Cookie c = (uDAO.recuperaUsuarioPorCookie(cooks));
			Usuario candidato;
			if(c != null){
				if(!c.getValue().equals("")){
					candidato = uDAO.recuperar((long) Integer.parseInt(c.getValue()));
					List<Papel> listP = candidato.getPapelList();
					session.setAttribute("usuario_logado", candidato);
					session.setAttribute("Tipo", listP.get(listP.size()-1).getId());

					List<Noticia> noticias = this.nDAO.listar();
					model.addAttribute("noticias", noticias);
					
					return "menu";
				}
			}else{
				candidato = uDAO.recuperar(usuario.getLogin());
				
				if(candidato!=null){
					if(candidato.getSenha().equals(usuario.getSenha())){
						Usuario aux = uDAO.recuperar(usuario.getLogin());
						
						List<Papel> listP = aux.getPapelList();
						
						if(permanecer == true){
							Cookie cookie = new Cookie("Orbita", ""+candidato.getId());
						    response.addCookie(cookie);	
						}
					    
					    
						session.setAttribute("usuario_logado", candidato);
						session.setAttribute("listaTipos", listP);
						session.setAttribute("Tipo", listP.get(listP.size()-1).getId());

						List<Noticia> noticias = this.nDAO.listar();
						model.addAttribute("noticias", noticias);
						
						return "menu";
					}
				}
			}
		}else{
			List<Noticia> noticias = this.nDAO.listar();
			model.addAttribute("noticias", noticias);
			return "menu";
		}
		
		return "falha";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response){
		session.invalidate();
		Cookie[] cooks = request.getCookies();
		
		for (Cookie cookie : cooks) {
			if(cookie.getName().equals("Orbita")){
				cookie.setValue(null);
				response.addCookie(cookie);
				break;
			}
		}
		
		return "redirect:loginFormulario";
	}
	/*@RequestMapping("/loginCaptcha")
	public String inserirNoticia(HttpServletRequest request, Usuario usuario, HttpSession session, Model model){
		System.out.println(request.getParameter("secaoValores"));
		//response.setContentType("text/html");
		
	       //Dados de acesso do cliente.
	       //String usuario = request.getParameter("txtUsuario");
	       //String senha = request.getParameter("txtSenha");
	
	       //Desafio e a resposta do cliente (reCAPTCHA).
	       String challenge = request.getParameter("recaptcha_challenge_field");
	       String uresponse = request.getParameter("recaptcha_response_field");
	
	       //IP para ser passado para os servidores do reCAPTCHA.
	       String remoteAddr = request.getRemoteAddr();
	 
	       //Chave privada.
	       final String privateKey = "6LekLCETAAAAAOt_8ioQ3-GuJxPyBvyenR1HpE3N";
	
	       ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
	
	       //Inserimos nossa chave privada.
	       reCaptcha.setPrivateKey(privateKey);
	
	       ReCaptchaResponse reCaptchaResponse = 
	                reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);
	
	       //Validamos se a resposta ao desafio CAPTCHA foi correta.
	       if(reCaptchaResponse.isValid()) {
		
		
		Usuario candidato = uDAO.recuperar(usuario.getLogin());
		MD5Criptografia md5 = new MD5Criptografia();
		System.out.println("candidato " + candidato.getSenha());
		System.out.println("usuer "+ usuario.getSenha());
		List<Papel> p = new ArrayList<Papel>();
        if(candidato!=null){
			if(candidato.getSenha().equals(usuario.getSenha())){
				//Papel aux = pDAO.recuperarPU(usuario.getId());
				Usuario aux = uDAO.recuperar(usuario.getLogin());
				//p.add(this.pDAO.recuperar((long) Integer.parseInt(req.getParameter("papel"))));
				//System.out.println(aux.getNome());
				Papel superP = null;
				
				List<Papel> listP = aux.getPapelList();
				/*if(aux.getPapelList() != null){
					for(Papel px:aux.getPapelList()){
						superP = px;
						System.out.println(px.getPapel()+aux.getPapelList().size());
					}
				}*/
				/*
				System.out.println(listP.size());
				if(listP.get(listP.size()-1).getId()== 1){
					session.setAttribute("usuario_logado", candidato);
					System.out.println("usuario_logado");
				}
				else if(listP.get(listP.size()-1).getId() == 2){
					session.setAttribute("jornalista_logado", candidato);
					System.out.println("jornalista_logado");
				}
				else if(listP.get(listP.size()-1).getId() == 3){
					session.setAttribute("redator_logado", candidato);
					System.out.println("redator_logado");
				}else{
					session.setAttribute("administrador_logado", candidato);
					System.out.println("administrador_logado");
				}
				//session.setAttribute("usuario_logado", candidato);
				session.setAttribute("Tipo", listP.get(listP.size()-1).getId());

				List<Noticia> noticias = this.nDAO.listar();
				model.addAttribute("noticias", noticias);
				
				
				//return "menu";
			}
		}
		//return "redirect:loginFormulario";

	    	   session.setAttribute("erro", "inserido");
	       }else {
	    	   //response.getOutputStream().print("O desafio reCAPTCHA foi respondido incorretamente! :-(");
	    	   session.setAttribute("erro", "<font color=red>Captcha digitado incorretamente.</font><br />");
	    	   return "redirect:irJornal";
	         }
	 
	         //response.getOutputStream().flush();
		return "menu";
	}
	*/
	
}