package br.cardapio.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.cardapio.bean.Cardapio;
import br.cardapio.recursos.Conexao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class CardapioDAO {
	public void adiciona(Cardapio cardapio){
		String sql = "INSERT INTO bd_cardapio.cardapio (id_estabelecimento, data_modificacao) "
				+ "VALUES (?, ?)";
	
		try{
			Connection conn = (Connection) Conexao.getConexao();
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
			
			//java.util.Date dataUtil = new java.util.Date();  
			java.sql.Date dataSql = new java.sql.Date(cardapio.getDataModificacao().getTime());  
			stmt.setLong(1, cardapio.getIdEstabelecimento());
			stmt.setDate(2, dataSql);
			
			stmt.execute();
			stmt.close();
			conn.close();
		} catch (SQLException e){
			throw new RuntimeException (e);
		}			
	}
	
	
	public void altera(Cardapio cardapio) {
	     String sql = "UPDATE bd_cardapio.cardapio SET id_estabelecimento=?, data_modificacao=? "
	     		+ "WHERE id=?";
	     try {
	    	 Connection conn = (Connection) Conexao.getConexao();
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
	        
			 java.sql.Date dataSql = new java.sql.Date(cardapio.getDataModificacao().getTime());  
			
			 stmt.setLong(1, cardapio.getIdEstabelecimento());
			 stmt.setDate(2, dataSql);
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
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("DELETE FROM bd_cardapio.cardapio "
	         		+ "WHERE id=?");
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
	         		+ "WHERE cardapio.id_estabelecimento = ?");
	         
	         stmt.setLong(1, idEstabelecimento);
	         ResultSet rs = stmt.executeQuery();
	         Cardapio cardapio = new Cardapio();
	         cardapio.setId(0);
	         while (rs.next()) {
	        	 cardapio.setId(rs.getLong("id"));
	        	 cardapio.setIdEstabelecimento(rs.getLong("id_estabelecimento"));
	        	 java.util.Date dataUtil = new java.sql.Date(rs.getDate("data_modificacao").getTime()); //Cria Data Util, que é passada ao Obj
	        	 cardapio.setDataModificacao(dataUtil);
	        	 break;
	         }
	         rs.close();
	         stmt.close();
	         conn.close();
	         System.out.println("Dentro DAO ID CARDAPIO: " + Long.toString(cardapio.getId()));
	         return cardapio;
	        
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	}  
}
