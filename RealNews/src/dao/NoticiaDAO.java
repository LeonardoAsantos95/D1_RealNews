package dao;

import java.sql.Connection;




import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Noticia;

import java.sql.ResultSet;

public class NoticiaDAO {
	
	private  Connection conexao;
	
	public NoticiaDAO() {
		this.conexao = ConnectionFactory.conectar();
	}
	
	public void cadastrar(Noticia noticia) {
		
		String inserir = "INSERT INTO noticia"
				+ " (titulo,descricao, texto) "
				+ " VALUES(?, ?, ?) ";
		
		try ( PreparedStatement pst = conexao.prepareStatement(inserir)) {;
			pst.setString(1, noticia.getTitulo());
			pst.setString(2, noticia.getDescricao());
			pst.setString(3, noticia.getTexto());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela noticia.");
			ex.printStackTrace();
			
		}
	}
		
	public void alterar(Noticia noticia) {
			
			String inserir = "UPDATE noticia "
					+ "SET descricao = ?, titulo = ?, endereco = ? "
					+ " WHERE id = ? ";
			
			try (PreparedStatement pst = conexao.prepareStatement(inserir)) {
				
				pst.setString(1, noticia.getTitulo());
				pst.setString(2, noticia.getDescricao());
				pst.setString(3, noticia.getTexto());
				pst.setInt(4, noticia.getId());
				
				pst.execute();
				
			} catch (SQLException ex) {
				
				System.err.println("Não foi possível manipular "
						+ "a tabela noticia.");
				ex.printStackTrace();
				
		    	}
	}
			
		public void excluir(Noticia noticia) {
			
			String inserir = "DELETE FROM noticia "
					+ "WHERE id = ? ";
			
			try ( PreparedStatement pst = 
					conexao.prepareStatement(inserir) ) {
				
				pst.setInt(1, noticia.getId());
				
				pst.execute();
				
			} catch (SQLException ex) {
				
				System.err.println("Não foi possível manipular "
						+ "a tabela noticia.");
				ex.printStackTrace();
				}
		}
			
		public Noticia consultar (int id) {
			
			String inserir = "SELECT * FROM noticia "
					+ " WHERE id = ?";
			
			try ( PreparedStatement pst = conexao.prepareStatement(inserir) ) {
				
				pst.setInt(1, id);
				ResultSet resultado = pst.executeQuery();
				
				Noticia n = new Noticia();
				if (resultado.next()) {
					n.setId(id);
					n.setTitulo(resultado.getString("descricao"));
					n.setDescricao(resultado.getString("titulo"));
					n.setTexto(resultado.getString("texto"));
				}
				return n;
				
			} catch (SQLException ex) {
				
				System.err.println("Não foi possível manipular "
						+ "a tabela noticia.");
				ex.printStackTrace();
				
				return null;
			}
		}
		
		public ArrayList<Noticia> listaNoticia() {
			
			String inserir = "SELECT * FROM noticia";
			
			try ( PreparedStatement pst = conexao.prepareStatement(inserir) ) {
				
				ResultSet resultado = pst.executeQuery();
				
				ArrayList<Noticia> lista = new ArrayList<>();
				while (resultado.next()) {
					Noticia n = new Noticia();
					n.setDescricao(resultado.getString("Descricao"));
					n.setTitulo(resultado.getString("titulo"));
					n.setTexto(resultado.getString("texto"));
					lista.add(n);
				}
				return lista;
				
				
			} catch (SQLException ex) {
				
				System.err.println("Não foi possível manipular "
						+ "a tabela noticia.");
				ex.printStackTrace();
				
				return null;
			}
		}
			
}
		
	

	

