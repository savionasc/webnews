package br.ufc.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Papel;
import br.ufc.model.Usuario;


public class InterceptadorGeral extends HandlerInterceptorAdapter {
	@Autowired
	@Qualifier(value="usuarioDAO")
	UsuarioDAO uDAO;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		
		String URI = request.getRequestURI();
		if(URI.endsWith("loginFormulario") ||
				   URI.endsWith("login") ||
				   URI.endsWith("irJornal") ||
				   URI.endsWith("inserirUsuarioFormulario") ||
				   URI.endsWith("inserirUsuario") || URI.endsWith("listarComentarios")
				   || URI.endsWith("home") || URI.endsWith("construirEstrutura")
				   || URI.contains("resources") || URI.endsWith("logout"))
			
				return true;
		if(session.getAttribute("usuario_logado") != null){
			Usuario usuario = uDAO.recuperar(((Usuario) session.getAttribute("usuario_logado")).getId());
			List<Papel> p = usuario.getPapelList();
			if(p != null){
				for (Papel papel : p) {
					if((URI.endsWith("listarSecoes") || URI.endsWith("inserirClassifcado")
							|| URI.contains("listarNoticia") || URI.contains("verFavoritos")
							|| URI.contains("adicionarFavorito") || URI.endsWith("listarClassificados")
							|| URI.endsWith("inserirClassificadoFormulario") || URI.endsWith("listarNotificacoes")
							|| URI.endsWith("buscarNoticias") || URI.contains("inserirComentario")
							|| URI.contains("visualizarNotificacao") || URI.contains("apagarNotificacao"))
							&& papel.getPapel().equals("Leitor")){
						return true;
					}
					
					if((URI.endsWith("inserirNoticiaFormulario") || URI.endsWith("listarSecoes")
							|| URI.endsWith("inserirNoticia"))
							&& papel.getPapel().equals("Jornalista")){
						System.out.println("passou");
						return true;
					}
					if((URI.endsWith("inserirSecaoFormulario") || URI.endsWith("listarUsuario")
							|| URI.endsWith("listarClassificadosInativos") || URI.endsWith("inserirPapelFormulario")
							|| URI.endsWith("resultados") || URI.contains("apagarNoticia")
							|| URI.contains("ativarClassificado") || URI.contains("apagarClassificado"))
							&& papel.getPapel().equals("Editor")){
						return true;
					}
					//response.sendRedirect("login");
				}
			}
		}		
		//if(request.getSession().getAttribute("usuario_logado")!=null){
			//return true;
		//}
		response.sendRedirect("loginFormulario");
		return false;
	}
}