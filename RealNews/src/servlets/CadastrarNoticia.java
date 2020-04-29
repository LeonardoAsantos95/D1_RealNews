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




@WebServlet("/CadastrarNoticia.do")
public class CadastrarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   			// Recebendo os dados do usuario: (capturando os parametros)
					String titulo = request.getParameter("titulo_noticia");		
					String texto= request.getParameter("texto_noticia");
					String descricao= request.getParameter("descricao_noticia");
					
					// Instaciar o objeto do tipo professor:
					Noticia noticia= new Noticia();
					noticia.setTitulo(titulo);
					noticia.setDescricao(descricao);
					noticia.setTexto(texto);
					
					
					//Enviar o objeto professor para service:
					NoticiaService NoticiaService = new NoticiaService();
					NoticiaService.cadastrar(noticia);
					
					//saida:	 
					PrintWriter saida = response.getWriter();
					saida.println("Noticia cadastrada com sucesso! <br><br>");
					saida.println("<a href='RealNews.html'> Cadastrar noticia</a> <br><br>");
					saida.println("<a href='ListarNoticia.do'> Ir para lista de noticias </a>");
					
					
				}
		
	}


