package br.cardapio.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cardapio.bean.ItemCardapio;
import br.cardapio.listas.ItemCardapioList;
import br.cardapio.recursos.Conexao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ItemCardapioDAO {

	public void adiciona(ItemCardapio itemCardapio){
		String sql = "INSERT INTO bd_cardapio.item_cardapio "
				+ "(id_secao_cardapio, nome_item, preco, descricao, foto, percentual_desconto, data_modificacao) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try{
			Connection conn = (Connection) Conexao.getConexao();
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
			
			stmt.setLong(1, itemCardapio.getIdSecaoCardapio());
			stmt.setString(2, itemCardapio.getNomeItem());
			stmt.setDouble(3, itemCardapio.getPreco());
			stmt.setString(4, itemCardapio.getDescricao());
			stmt.setString(5, itemCardapio.getFoto());
			stmt.setDouble(6, itemCardapio.getPercentualDesconto());
			java.sql.Date dataSql = new java.sql.Date(itemCardapio.getDataModificacao().getTime());
			stmt.setDate(7, dataSql);

			stmt.execute();
			stmt.close();
			conn.close();
		} catch (SQLException e){
			throw new RuntimeException (e);
		}			
	}
	
	
	public void altera(ItemCardapio itemCardapio) {
	     String sql = "update item_cardapio set id_secao_cardapio=?, nome_item=?, preco=?, descricao=?, foto=?, percentual_desconto=?, data_modificacao=?" +
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
	         java.sql.Date dataSql = new java.sql.Date(itemCardapio.getDataModificacao().getTime()); 
	         stmt.setDate(7, dataSql);
	         
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
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("DELETE FROM bd_cardapio.item_cardapio WHERE id=?");
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
	        	 java.util.Date dataUtil = new java.sql.Date(rs.getDate("data_modificacao").getTime()); //Cria Data Util, que � passada ao Obj
	        	 itemCardapio.setDataModificacao(dataUtil);
	        	 
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
	
	// Retorna os ItemsCard�pio do ID da Se��oCard�pio  e ID Card�pio passado, ex.: id: 1 - Bebidas, retornara todas bebidas, referente ao card�pio X da Se��o Y!
	public ItemCardapioList getListaItemsPorIdSecao(long idSecaoCardapio) {
		try {
	         ItemCardapioList listaItemCardapio = new ItemCardapioList();      
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
	        	 java.util.Date dataUtil = new java.sql.Date(rs.getDate("data_modificacao").getTime()); //Cria Data Util, que � passada ao Obj
	        	 itemCardapio.setDataModificacao(dataUtil);
	        	 
	        	 listaItemCardapio.add(itemCardapio);
	         }
	         rs.close();
	         stmt.close();
	         conn.close();
	         if (listaItemCardapio.isEmpty()){
	        	 	listaItemCardapio.setLista(null);
		         	return listaItemCardapio;
		         }else{
		        	return listaItemCardapio;
		         }
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }	
	}
	
	// Retorna uma lista de Itens que est�o em Promo��o, ou seja, que tem o percentual_desconto preenchido.
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
	        	 java.util.Date dataUtil = new java.sql.Date(rs.getDate("data_modificacao").getTime()); //Cria Data Util, que � passada ao Obj
	        	 itemCardapio.setDataModificacao(dataUtil);
	        	 
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
	
	
	
	public ItemCardapio getItemPorIdItem(long idItemCardapio) {
		try { 
			 ItemCardapio itemCardapio = new ItemCardapio();
	         Connection conn = (Connection) Conexao.getConexao();
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("SELECT * FROM item_cardapio"
	         		+ "WHERE item_cardapio.id = ?");
	         stmt.setLong(1, idItemCardapio);
	         ResultSet rs = stmt.executeQuery();
	         itemCardapio.setId(0);
	         while (rs.next()) {
	        	 itemCardapio.setId(rs.getLong("id"));
	        	 itemCardapio.setIdSecaoCardapio(rs.getLong("id_secao_cardapio"));
	        	 itemCardapio.setNomeItem(rs.getString("nome_item"));
	        	 itemCardapio.setPreco(rs.getDouble("preco"));
	        	 itemCardapio.setDescricao(rs.getString("descricao"));
	        	 itemCardapio.setFoto(rs.getString("foto"));
	        	 itemCardapio.setPercentualDesconto(rs.getDouble("percentual_desconto"));
	        	 java.util.Date dataUtil = new java.sql.Date(rs.getDate("data_modificacao").getTime()); //Cria Data Util, que � passada ao Obj
	        	 itemCardapio.setDataModificacao(dataUtil);
	        
	         }
	         rs.close();
	         stmt.close();
	         conn.close();
	         return itemCardapio;
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	}
	
	
}
