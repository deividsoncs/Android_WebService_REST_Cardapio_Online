package br.cardapio.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.cardapio.bean.SecaoCardapio;
import br.cardapio.recursos.Conexao;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class SecaoCardapioDAO {

	public void adiciona(SecaoCardapio secaoCardapio){
		String sql = "insert into secao_cardapio " + 
				"(id_cardapio, nome_secao_cardapio)" + 
				"values (?, ?)";
	
		try{
			Connection conn = (Connection) Conexao.getConexao();
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
			
			stmt.setLong(1, secaoCardapio.getIdCardapio());
			stmt.setString(2, secaoCardapio.getNomeSecaoCardapio());
			
			stmt.execute();
			stmt.close();
			conn.close();
		} catch (SQLException e){
			throw new RuntimeException (e);
		}			
	}
	
	
	public void altera(SecaoCardapio secaoCardapio) {
	     String sql = "update secao_cardapio set id_cardapio=?, nome_secao_cardapio=?" +
	             "where id=?";
	     try {
	    	 Connection conn = (Connection) Conexao.getConexao();
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
	         stmt.setLong(1, secaoCardapio.getIdCardapio());
			 stmt.setString(2, secaoCardapio.getNomeSecaoCardapio());
	         stmt.setLong(3, secaoCardapio.getId());
	         
	         stmt.execute();
	         stmt.close();
	         conn.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
	
	public void remove(long idSecaoCardapio) {
	     try {
	    	 Connection conn = (Connection) Conexao.getConexao();
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("delete" +
	                 "from secao_cardapio where id=?");
	         stmt.setLong(1, idSecaoCardapio);
	         stmt.execute();
	         stmt.close();
	         conn.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
	
	public List <SecaoCardapio> getLista() {
		try {
	         List <SecaoCardapio> listaCardapio = new ArrayList <SecaoCardapio>();      
	         Connection conn = (Connection) Conexao.getConexao();
	         
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("select * from secao_cardapio");
	         ResultSet rs = stmt.executeQuery();
	         while (rs.next()) {
	      
	        	 SecaoCardapio secaoCardapio = new SecaoCardapio();
	        	 secaoCardapio.setId(rs.getLong("id"));
	        	 secaoCardapio.setIdCardapio(rs.getLong("id_cardapio"));
	        	 secaoCardapio.setNomeSecaoCardapio(rs.getString("nome_secao_cardapio"));
	        	
	        	 listaCardapio.add(secaoCardapio);
	         }
	         rs.close();
	         stmt.close();
	         conn.close();
	         
	         if (listaCardapio.isEmpty()){
		         	return null;
		         }else{
		        	return listaCardapio;
		         }
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	}
	
	
	//Retorna lista de Seções do Cardápio passando a ID do Cardápio
	public List <SecaoCardapio> getListaSecaoPorIdCardapio(long idCardapio) {
		try {
	         List <SecaoCardapio> listaCardapio = new ArrayList <SecaoCardapio>();      
	         Connection conn = (Connection) Conexao.getConexao();
	         
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("SELECT * FROM bd_cardapio.secao_cardapio WHERE secao_cardapio.id_cardapio = ?");
	         stmt.setLong(1, idCardapio);
	         ResultSet rs = stmt.executeQuery();
	         while (rs.next()) {
	      
	        	 SecaoCardapio secaoCardapio = new SecaoCardapio();
	        	 secaoCardapio.setId(rs.getLong("id"));
	        	 secaoCardapio.setIdCardapio(rs.getLong("id_cardapio"));
	        	 secaoCardapio.setNomeSecaoCardapio(rs.getString("nome_secao_cardapio"));
	        	
	        	 listaCardapio.add(secaoCardapio);
	         }
	         rs.close();
	         stmt.close();
	         conn.close();
	         
	         if (listaCardapio.isEmpty()){
		         	return null;
		         }else{
		        	return listaCardapio;
		         } 
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	}
}
