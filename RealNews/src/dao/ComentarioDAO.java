package dao;

import java.sql.Connection;




import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Comentario;


import java.sql.ResultSet;

public class ComentarioDAO {
	
	private  Connection conexao;
	
	public ComentarioDAO() {
		this.conexao = ConnectionFactory.conectar();
	}
	
	public void cadastrar(Comentario comentario) {
		
		String inserir = "INSERT INTO comentario" + "(nome, texto, fk_notica_id) "
				+ " VALUES(?, ?, ?) ";
		
		try ( PreparedStatement pst = conexao.prepareStatement(inserir)) {
			
			pst.setString(1, comentario.getNome());
			pst.setString(2, comentario.getTexto());
			pst.setInt(3, comentario.getFkNoticiaId());
			
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela comentario.");
			ex.printStackTrace();
			
		}
	}
	
	public void alterar(Comentario comentario) {
		
		String alterar = "UPDATE comentario "
				+ "SET nome = ?, texto = ? "
				+ " WHERE id = ? ";
		
		try (PreparedStatement pst = conexao.prepareStatement(alterar)) {
			
			pst.setString(1, comentario.getNome());
			pst.setString(2, comentario.getTexto());
			pst.setInt(3, comentario.getId());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela comentario.");
			ex.printStackTrace();
			
	    	}
}
		
	public void excluir(Comentario comentario) {
		
		String excluir = "DELETE FROM comentario "
				+ "WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(excluir) ) {
			
			pst.setInt(1, comentario.getId());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela comentario.");
			ex.printStackTrace();
			}
	}
		
	public Comentario consultar (int id) {
		
		String consultar = "SELECT * FROM comentario "
				+ " WHERE id = ?";
		
		try ( PreparedStatement pst = conexao.prepareStatement(consultar) ) {
			pst.setInt(1, id);
			ResultSet resultado = pst.executeQuery();
			
			Comentario c = new Comentario();
			if (resultado.next()) {
				c.setNome(resultado.getString("nome"));
				c.setTexto(resultado.getString("texto"));
				c.setId(id);
				c.setFkNoticiaId(resultado.getInt("fk_noticia_id"));
			}
			return c;
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela comentario.");
			ex.printStackTrace();
			
			return null;
		}
	}
	
	public ArrayList<Comentario> listaComentario(int idNoticia) {
		
		String inserir = "SELECT * FROM comentario";
		
		try ( PreparedStatement pst = conexao.prepareStatement(inserir) ) {
			
			ResultSet resultado = pst.executeQuery();
			
			ArrayList<Comentario> lista = new ArrayList<>();
			while (resultado.next()) {
				Comentario c = new Comentario();
				c.setNome(resultado.getString("nome"));
				c.setTexto(resultado.getString("texto"));
				c.setId(resultado.getInt("id"));
				c.setFkNoticiaId(resultado.getInt("fk_noticia_id"));
				lista.add(c);
			}
			return lista;
			
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela comentario.");
			ex.printStackTrace();
			
			return null;
		}
	}
	
	public ArrayList<Comentario> listarComentariosNoticia(int idNoticia) {

		String sql = "SELECT * FROM comentario AS c " + "INNER JOIN noticia AS n " + "ON n.id = c.fk_noticia_id "
				+ "WHERE n.id = ?;";

		try (PreparedStatement pst = conexao.prepareStatement(sql)) {

			pst.setInt(1, idNoticia);
			ResultSet resultado = pst.executeQuery();

			ArrayList<Comentario> lista = new ArrayList<>();
			while (resultado.next()) {
				Comentario c = new Comentario();
				c.setNome(resultado.getString("nome"));
				c.setTexto(resultado.getString("texto"));
				c.setId(resultado.getInt("id"));
				c.setFkNoticiaId(resultado.getInt("fk_noticia_id"));
				lista.add(c);
			}
			return lista;

		} catch (SQLException ex) {

			System.err.println("N�o foi poss�vel manipular a tabela Comentario.");
			ex.printStackTrace();

			return null;
		}
	}
		
}

	

		

			
	
