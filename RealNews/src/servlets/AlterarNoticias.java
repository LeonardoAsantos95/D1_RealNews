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


@WebServlet("/AlterarNoticias.do")
public class AlterarNoticias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//capturando o id para alterar noticia:
		int id = Integer.parseInt(request.getParameter("id"));
		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		String texto = request.getParameter("texto");

		
		//solicitando a service os dados da noticia do tirulo informado:
		NoticiaService noticiaService = new NoticiaService();
		Noticia noticia = noticiaService.consultar(id);
		
		//saida:
		//Formulario para alterar os dados da noticia:
		response.setContentType("text/html");
		
		//Criando um objeto para saida de caracteres
		PrintWriter saida = response.getWriter();
		saida.println("<form action='AlterarNoticias.do' method='post'>");
		saida.println("Id: " + noticia.getId());
		saida.println("<input type=\"hidden\" name='id_noticia' value='"+ noticia.getId() +"'> <br><br> ");
		saida.println("Titulo: ");
		saida.println("<input type=\"text\" name='titulo_noticia' value='"+ noticia.getTitulo() +"'> <br><br> ");
		saida.println("descricao: ");
		saida.println("<input type=\"text\" name='descricao_noticia' value='"+ noticia.getDescricao() +"'> <br><br> ");
		saida.println("texto: ");
		saida.println("<input type=\"text\" name='texto_noticia' value='"+ noticia.getTexto() +"'> <br><br> ");
		saida.println("<input type='submit' value='Alterar'>");
		saida.println("</form>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Recebendo os dados do usuario: (capturando os parametros):
		int id = Integer.parseInt(request.getParameter("id"));
		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		String texto = request.getParameter("texto");
		
		//Formulario para alterar os dados da noticia:
		  response.setContentType("text/html");
		  
		// Instaciar o objeto do tipo produto:
			Noticia noticia= new Noticia();
			noticia.setId(id);
			noticia.setTitulo(titulo);
			noticia.setDescricao(descricao);
			noticia.setTexto(texto);
			
		 
		//Enviar o objeto para service:
		NoticiaService noticiaService = new NoticiaService();
		noticiaService.alterar(noticia);
		
		//saida:
		PrintWriter saida = response.getWriter();
		saida.println("Alteração realizada com sucesso! <br><br>");
		saida.println("<a href='ListarNoticia.do'> Ir para lista de noticia </a>");
		
		
		
		
	}

}
