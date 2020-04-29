package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Comentario;


@WebServlet("/CadastrarComentario.do")
public class CadastrarComentario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Recebendo os dados do usuario: (capturando os parametros):
		String nome = request.getParameter("nome_comentario");		
		String texto = request.getParameter("texto_comentario");
		
		
		//instaciando um objto comentario:
		Comentario comentario = new Comentario();
	    comentario.setNome(nome);
	    comentario.setTexto(texto);
	    comentario.setFkNoticiaId(Integer.parseInt(request.getParameter("id_noticia")));
	    
	}

}
