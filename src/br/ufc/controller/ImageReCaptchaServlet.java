package br.ufc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tanesha.recaptcha.ReCaptcha;
import net.tanesha.recaptcha.ReCaptchaFactory;

/**
 * Servlet implementation class ImageReCaptchaServlet
 */
@WebServlet("/ImageReCaptchaServlet")
public class ImageReCaptchaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageReCaptchaServlet() {
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
			//final String publicKey = "6LdNl9QSAAAAAPeGVBtdUr7slwEDC1L94aYEcDv";
		 	//final String privateKey = "6LdNl9QSAAAAABJL1LDMrkxhEkNKktXHWlFTFtm";
		 
			final String publicKey = "6LekLCETAAAAAGMlBkeQoo3mtsg89gUIWKrAm8bP";
			final String privateKey = "6LekLCETAAAAAOt_8ioQ3-GuJxPyBvyenR1HpE3N";
		 	//Obtemos uma instância da classe ReCaptcha.
		 	ReCaptcha c = ReCaptchaFactory.newReCaptcha(publicKey, privateKey, true);
		
		 	//Obtemos o código HTML para apresentar o reCAPTCHA WIDGET.
		 	String reCaptchaChallenge = c.createRecaptchaHtml(null, null);
		 
		 	//Armazenamos o HTML no escopo de request.
		 	request.setAttribute("reCapchaChallenge", reCaptchaChallenge);
		
		 	//Acessamos nossa página com o formulário.
		 	RequestDispatcher nextView = request.getRequestDispatcher("/irJornal");
		
		 	nextView.forward(request, response);
	}

}
