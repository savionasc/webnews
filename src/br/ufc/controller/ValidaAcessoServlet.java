package br.ufc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

/**
 * Servlet implementation class ValidaAcessoServlet
 */
@WebServlet("/ValidaAcessoServlet")
public class ValidaAcessoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidaAcessoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
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
		           response.getOutputStream().print("O desafio reCAPTCHA e os dados de acesso foram respondidos adequadamente!!! :-)");
		 		//}  
		         }else {
		        	 response.getOutputStream().print("O desafio reCAPTCHA foi respondido incorretamente! :-(");
		         }
		 
		         response.getOutputStream().flush();
	}

}
