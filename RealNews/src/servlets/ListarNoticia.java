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


@WebServlet("/ListarNoticia.do")
public class ListarNoticia extends HttpServlet {
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
	 saida.println("html");
	 saida.println("<body>");
	 
	 ListaNoticia.forEach(
			 p -> {
				 saida.println("<tr>");
				 saida.println("<td>");
				 saida.println("<h1>" + p.getTitulo() + "<h1/>");
				 saida.println("</td>");
				 saida.println("<td>");		 
				 saida.println(p.getDescricao() + "<br>");
				 saida.println("</td>");
				 saida.println("<td>");
				 saida.println(p.getTexto() + "<br>");
				 saida.println("<td>");
				 
				 
				 /*Criando uma coluna para o link de exclusão: */
					saida.println("<td>");
					saida.println("<a href='ExcluirNoticia.do?id="+ p.getId() + "'> Excluir <br></a>");
					saida.println("</td>");	
					
					
					saida.println("</tr>");
					
					//coluna para link de atualzação:
					saida.println("<td>");
					saida.println("<a href='AlterarNoticias.do?id=" + p.getId() +"'> Alterar </a>");
					saida.println("</td>");
					saida.println("<br>");
					saida.println("<hr/>");
					
					
			 		}
			 
			 		);
	 
	 saida.println("</table>");
	 
	 
	 
	 
	}
		
}
