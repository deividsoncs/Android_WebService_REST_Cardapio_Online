package br.cardapio.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.cardapio.bean.Cardapio;
import br.cardapio.recursos.Conexao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class CardapioDAO {
	public void adiciona(Cardapio cardapio){
		String sql = "INSERT INTO cardapio " + 
				"(id_estabelecimento, data_modificacao)" + 
				"VALUES (?, ?)";
	
		try{
			Connection conn = (Connection) Conexao.getConexao();
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
			
			stmt.setLong(1, cardapio.getIdEstabelecimento());
			stmt.setDate(2, cardapio.getDataModificacao());
			
			stmt.execute();
			stmt.close();
			conn.close();
		} catch (SQLException e){
			throw new RuntimeException (e);
		}			
	}
	
	
	public void altera(Cardapio cardapio) {
	     String sql = "UPDATE cardapio SET id_estabelecimento=?, data_modificacao=?" +
	             "WHERE id=?";
	     try {
	    	 Connection conn = (Connection) Conexao.getConexao();
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
	         stmt.setLong(1, cardapio.getIdEstabelecimento());
			 stmt.setDate(2, cardapio.getDataModificacao());
	         stmt.setLong(3, cardapio.getId());
	         
	         stmt.execute();
	         stmt.close();
	         conn.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
	
	public void remove(long idCardapio) {
	     try {
	    	 Connection conn = (Connection) Conexao.getConexao();
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("DELETE" +
	                 "FROM cardapio WHERE id=?");
	         stmt.setLong(1, idCardapio);
	         stmt.execute();
	         stmt.close();
	         conn.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
	
	// Retorna o Cardápio referente a id do Estabelecimento Passado
	public Cardapio getCardapio(long idEstabelecimento) {
		try {
	           
	         Connection conn = (Connection) Conexao.getConexao();
	         
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("SELECT cardapio.* "
	         		+ "FROM bd_cardapio.cardapio, bd_cardapio.estabelecimento "
	         		+ "WHERE cardapio.id_estabelecimento = estabelecimento.id = ?");
	         
	         stmt.setLong(1, idEstabelecimento);
	         ResultSet rs = stmt.executeQuery();
	         Cardapio cardapio = new Cardapio();
	         
	         while (rs.next()) {
	        	 cardapio.setId(rs.getLong("id"));
	        	 cardapio.setIdEstabelecimento(rs.getLong("id_estabelecimento"));
	        	 cardapio.setDataModificacao(rs.getDate("data_modificacao"));
	         }
	         rs.close();
	         stmt.close();
	         conn.close();
	         if (cardapio.getId() != 0){
	        	 return cardapio;
	         }else{
	        	 return null;
	         }
	        
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	}  
}
