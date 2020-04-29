package service;

import java.util.ArrayList;

import dao.NoticiaDAO;
import model.Noticia;

public class NoticiaService {
	
	private NoticiaDAO noticiaDAO;
	
	/** Instacia um objeto um  noticiaDAO dentro do atributo  noticiaDAO.**/

	
	
	public NoticiaService() {
		this.noticiaDAO = new NoticiaDAO();
	}
	
	public void cadastrar (Noticia noticia) {
		this.noticiaDAO.cadastrar(noticia);
	}
	
	public void alterar(Noticia noticia) {
		this.noticiaDAO.alterar(noticia);
	}

	public void excluir(Noticia noticia) {
		this.noticiaDAO.excluir(noticia);
	}
	
	public Noticia consultar(int id) {
		return this.noticiaDAO.consultar(id);
	}
	
	public ArrayList<Noticia> ListaNoticia(){
		return this.noticiaDAO.listaNoticia();
	}

}
