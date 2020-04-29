package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noticia;
import service.NoticiaService;


@WebServlet("/Home.do")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		//Solicitar a lista de noticia:
		 NoticiaService noticiaService = new NoticiaService();
		
		// Instanciando uma lista de noticia (vazia = null):
		 ArrayList<Noticia> ListaNoticia = null;
		 
		 //carregando a lista com as noticia do BD:
		 ListaNoticia = noticiaService.ListaNoticia();
		 
		 //Definir o tipo de conteudo a ser enviado:
		 response.setContentType("text/html");
		 
		 //criando um objeto de saida de caracteres:
		 PrintWriter saida = response.getWriter();
		 
		 //Percorrer toda a lista de objetos noticia e imprimir os dados:
		 //saida.println("html");
		// saida.println("<body>");
		 
		 ListaNoticia.forEach(
				 p -> {
					 
					 saida.println("<h1>" + p.getTitulo() + "<h1/> <br>");
					 saida.println("<h3>" + p.getDescricao() + "<h3/>"); 
					 saida.println("<h5>" + p.getTexto() + "<h5/>");
					 
					 //comentario
					 //criando um objeto para saida de caracteres:
					 saida.println("<form action='CadastrarComentario.do' method='get'>");
					 saida.println("Nome: ");
					 saida.println("<input type=\"text\" name='nome_comentario'> <br><br> ");
					 saida.println("Comentario: ");
					 saida.println("<input type=\"text\" name='comentario_comentario' > <br><br> ");  
					 saida.println("<input type='submit' value='Comentar'><br>");
					 saida.println("<hr>");	
					 
				 	}
				 
				 	);
		 
		 
		 
		
	}

}
