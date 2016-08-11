package br.cardapio.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.cardapio.bean.ItemCardapio;
import br.cardapio.recursos.Conexao;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ItemCardapioDAO {

	public void adiciona(ItemCardapio itemCardapio){
		String sql = "insert into item_cardapio " + 
				"(id_secao_cardapio, nome_item, preco, descricao, foto, percentual_desconto, data_modificacao)" + 
				"values (?, ?, ?, ?, ?, ?, ?)";
		
		try{
			Connection conn = (Connection) Conexao.getConexao();
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
			
			stmt.setLong(1, itemCardapio.getIdSecaoCardapio());
			stmt.setString(2, itemCardapio.getNomeItem());
			stmt.setDouble(3, itemCardapio.getPreco());
			stmt.setString(4, itemCardapio.getDescricao());
			stmt.setString(5, itemCardapio.getFoto());
			stmt.setDouble(6, itemCardapio.getPercentualDesconto());
			stmt.setDate(7, itemCardapio.getDataModificacao());

			stmt.execute();
			stmt.close();
			conn.close();
		} catch (SQLException e){
			throw new RuntimeException (e);
		}			
	}
	
	
	public void altera(ItemCardapio itemCardapio) {
	     String sql = "update item_cardapio set id_secao_cardapio=?, nome_item=?, preco=?, descricao=?, foto=?, percentual_desconto=?, data_modificacao=?," +
	             "where id=?";
	     try {
	    	 Connection conn = (Connection) Conexao.getConexao();
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
	         stmt.setLong(1, itemCardapio.getIdSecaoCardapio());
	         stmt.setString(2, itemCardapio.getNomeItem());
	         stmt.setDouble(3, itemCardapio.getPreco());
	         stmt.setString(4, itemCardapio.getDescricao());
	         stmt.setString(5, itemCardapio.getFoto());
	         stmt.setDouble(6, itemCardapio.getPercentualDesconto());
	         stmt.setDate(7, itemCardapio.getDataModificacao());
	         
	         stmt.setLong(8, itemCardapio.getId());
	         
	         stmt.execute();
	         stmt.close();
	         conn.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
	
	public void remove(long idItemCardapio) {
	     try {
	    	 Connection conn = (Connection) Conexao.getConexao();
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("delete" +
	                 "from item_cardapio where id=?");
	         stmt.setLong(1, idItemCardapio);
	         stmt.execute();
	         stmt.close();
	         conn.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
	
	public List <ItemCardapio> getLista() {
		try {
	         List <ItemCardapio> listaItemCardapio = new ArrayList <ItemCardapio>();      
	         Connection conn = (Connection) Conexao.getConexao();
	         
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("select * from item_cardapio");
	         ResultSet rs = stmt.executeQuery();
	 
	         while (rs.next()) {
	      
	        	 ItemCardapio itemCardapio = new ItemCardapio();
	        	 itemCardapio.setId(rs.getLong("id"));
	        	 itemCardapio.setIdSecaoCardapio(rs.getLong("id_secao_cardapio"));
	        	 itemCardapio.setNomeItem(rs.getString("nome_item"));
	        	 itemCardapio.setPreco(rs.getDouble("preco"));
	        	 itemCardapio.setDescricao(rs.getString("descricao"));
	        	 itemCardapio.setFoto(rs.getString("foto"));
	        	 itemCardapio.setPercentualDesconto(rs.getDouble("percentual_desconto"));
	        	 itemCardapio.setDataModificacao(rs.getDate("date"));
	        	 
	        	 listaItemCardapio.add(itemCardapio);
	         }
	         rs.close();
	         stmt.close();
	         conn.close();
	         
	         if (listaItemCardapio.isEmpty()){
		         	return null;
		         }else{
		        	return listaItemCardapio;
		         }
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	}
	
	// Retorna os ItemsCardápio do ID da SeçãoCardápio  e ID Cardápio passado, ex.: id: 1 - Bebidas, retornara todas bebidas, referente ao cardápio X da Seção Y!
	public List <ItemCardapio> getListaItemsPorIdSecao(long idSecaoCardapio) {
		try {
	         List <ItemCardapio> listaItemCardapio = new ArrayList <ItemCardapio>();      
	         Connection conn = (Connection) Conexao.getConexao();
	         
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("SELECT item_cardapio.* "
	         		+ "FROM bd_cardapio.item_cardapio, bd_cardapio.secao_cardapio "
	         		+ "WHERE item_cardapio.id_secao_cardapio = secao_cardapio.id "
	         		+ "AND secao_cardapio.id = ?");
	         stmt.setLong(1, idSecaoCardapio);
	         ResultSet rs = stmt.executeQuery();
	 
	         while (rs.next()) {
	      
	        	 ItemCardapio itemCardapio = new ItemCardapio();
	        	 itemCardapio.setId(rs.getLong("id"));
	        	 itemCardapio.setIdSecaoCardapio(rs.getLong("id_secao_cardapio"));
	        	 itemCardapio.setNomeItem(rs.getString("nome_item"));
	        	 itemCardapio.setPreco(rs.getDouble("preco"));
	        	 itemCardapio.setDescricao(rs.getString("descricao"));
	        	 itemCardapio.setFoto(rs.getString("foto"));
	        	 itemCardapio.setPercentualDesconto(rs.getDouble("percentual_desconto"));
	        	 itemCardapio.setDataModificacao(rs.getDate("data_modificacao"));
	        	 
	        	 listaItemCardapio.add(itemCardapio);
	         }
	         rs.close();
	         stmt.close();
	         conn.close();
	         if (listaItemCardapio.isEmpty()){
		         	return null;
		         }else{
		        	return listaItemCardapio;
		         }
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }	
	}
	
	// Retorna uma lista de Itens que estão em Promoção, ou seja, que tem o percentual_desconto preenchido.
	public List <ItemCardapio> getListaPorItemEmPromocao() {
		try {
	         List <ItemCardapio> listaItemCardapio = new ArrayList <ItemCardapio>();      
	         Connection conn = (Connection) Conexao.getConexao();
	         
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("SELECT item_cardapio.* "
	         		+ "FROM bd_cardapio.item_cardapio "
	         		+ "WHERE item_cardapio.percentual_desconto IS NOT NULL");
	         ResultSet rs = stmt.executeQuery();
	 
	         while (rs.next()) {
	      
	        	 ItemCardapio itemCardapio = new ItemCardapio();
	        	 itemCardapio.setId(rs.getLong("id"));
	        	 itemCardapio.setIdSecaoCardapio(rs.getLong("id_secao_cardapio"));
	        	 itemCardapio.setNomeItem(rs.getString("nome_item"));
	        	 itemCardapio.setPreco(rs.getDouble("preco"));
	        	 itemCardapio.setDescricao(rs.getString("descricao"));
	        	 itemCardapio.setFoto(rs.getString("foto"));
	        	 itemCardapio.setPercentualDesconto(rs.getDouble("percentual_desconto"));
	        	 itemCardapio.setDataModificacao(rs.getDate("date"));
	        	 
	        	 listaItemCardapio.add(itemCardapio);
	         }
	         rs.close();
	         stmt.close();
	         conn.close();
	         
	         if (listaItemCardapio.isEmpty()){
		         	return null;
		         }else{
		        	return listaItemCardapio;
		         }
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	}
}
