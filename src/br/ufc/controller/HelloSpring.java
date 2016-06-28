package br.ufc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloSpring {
	
	@RequestMapping("/testelingua")
	public String testelingua(){
		
		return "testelingua.jsp";
	}
	@RequestMapping("/helloSpring")
	public String helloSpring(){
		System.out.println("Entrei no Hello Spring!");
		
		return "hello_ok";
	}
	
	@RequestMapping("/irJornal")
	public String irJornal(){
		
		return "pages/p";
	}
	
	@RequestMapping("/hup")
	public String inserirNoticia(HttpServletRequest request, HttpSession session){
		//System.out.println(request.getParameter("secaoValores"));
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
	
	         //Validamos se os dados do usuário estão corretos.
	         //if(isClienteValido(usuario, senha) == true) {
	           //response.getOutputStream().print("O desafio reCAPTCHA e os dados de acesso foram respondidos adequadamente!!! :-)");
	 		//}  
	    	   //aluno.setCaptcha(6.0);  
	    	   session.setAttribute("erro", "inserido");
	       }else {
	    	   //response.getOutputStream().print("O desafio reCAPTCHA foi respondido incorretamente! :-(");
	    	   session.setAttribute("erro", "<font color=red>Captcha digitado incorretamente.</font><br />");
	    	   return "redirect:irJornal";
	         }
	 
	         //response.getOutputStream().flush();
		return "noticia/noticia_inserido_ok";
	}
}
