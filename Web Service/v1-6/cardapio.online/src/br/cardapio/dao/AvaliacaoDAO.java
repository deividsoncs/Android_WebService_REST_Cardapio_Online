package br.cardapio.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cardapio.bean.Avaliacao;
import br.cardapio.recursos.Conexao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class AvaliacaoDAO {

	public void adiciona(Avaliacao avaliacao){
		String sql = "insert into avaliacao " + 
				"(id_estabelecimento, relato, positivo)" + 
				"values (?, ?, ?)";
	
		try{
			Connection conn = (Connection) Conexao.getConexao();
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
			
			stmt.setLong(1, avaliacao.getIdEstabelecimento());
			stmt.setString(2, avaliacao.getRelato());
			stmt.setByte(3, avaliacao.getPositivo());
			
			stmt.execute();
			stmt.close();
			conn.close();
		} catch (SQLException e){
			throw new RuntimeException (e);
		}			
	}
	
	
	public void altera(Avaliacao avaliacao) {
	     String sql = "update avaliacao set id_estabelecimento=?, relato=?, positivo" +
	             "where id=?";
	     try {
	    	 Connection conn = (Connection) Conexao.getConexao();
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
	         stmt.setLong(1, avaliacao.getIdEstabelecimento());
			 stmt.setString(2, avaliacao.getRelato());
			 stmt.setByte(3, avaliacao.getPositivo());
	         stmt.setLong(4, avaliacao.getId());
	         
	         stmt.execute();
	         stmt.close();
	         conn.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
	
	
	public List <Avaliacao> getListaPorIdEstabelecimento(long IdEstabelecimento) {
		try {
	         List <Avaliacao> listaAvaliacao= new ArrayList <Avaliacao>();      
	         Connection conn = (Connection) Conexao.getConexao();
	         
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("SELECT avaliacao.* "
	         		+ "FROM bd_cardapio.avaliacao, bd_cardapio.estabelecimento "
	         		+ "WHERE avaliacao.id_estabelecimento = estabelecimento.id AND estabelecimento.id = ?");
	         stmt.setLong(1, IdEstabelecimento);
	         ResultSet rs = stmt.executeQuery();
	 
	         while (rs.next()) {
	      
	        	 Avaliacao avaliacao = new Avaliacao();
	        	 avaliacao.setId(rs.getLong("id"));
	        	 avaliacao.setIdEstabelecimento(rs.getLong("id_estabelecimento"));
	        	 avaliacao.setRelato(rs.getString("relato"));
	        	 avaliacao.setPositivo(rs.getByte("positivo"));
	        	 
	        	 listaAvaliacao.add(avaliacao);
	         }
	         rs.close();
	         stmt.close();
	         conn.close();
	         if (listaAvaliacao.isEmpty()){
		         	return null;
		         }else{
		        	return listaAvaliacao;
		         }
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	}
	
	public void remove(long idAvaliacao) {
	     try {
	    	 Connection conn = (Connection) Conexao.getConexao();
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("delete" +
	                 "from avaliacao where id=?");
	         stmt.setLong(1, idAvaliacao);
	         stmt.execute();
	         stmt.close();
	         conn.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }

}
