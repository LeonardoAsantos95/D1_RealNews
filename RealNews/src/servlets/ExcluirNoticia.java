package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noticia;
import service.NoticiaService;


@WebServlet("/ExcluirNoticia.do")
public class ExcluirNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				//capturando o id da noticia que o usuario quer alterar:
				int id = Integer.parseInt(request.getParameter("id"));
			
				//instanciando um objeto do tipo noticia:
				Noticia noticia = new Noticia();
				noticia.setId(id);
				
				//Solicitando a service que remova o professor:
				NoticiaService noticiaService = new NoticiaService();
				noticiaService.excluir(noticia);
				
				//saida:	 
				PrintWriter saida = response.getWriter();
				saida.println("Noticia excluida com sucesso! <br><br>");
				saida.println("<a href='ListarNoticia.do'> Voltar para lista de noticia </a>");
	}

}
