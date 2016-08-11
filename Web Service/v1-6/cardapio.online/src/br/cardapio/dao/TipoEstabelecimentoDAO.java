package br.cardapio.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cardapio.bean.TipoEstabelecimento;
import br.cardapio.recursos.Conexao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class TipoEstabelecimentoDAO {
	
	public void adiciona(TipoEstabelecimento tipoEstabelecimento){
		String sql = "INSERT INTO tipo_estabelecimento (tipo_estabelecimento) VALUES (?)";
	
		try{
			Connection conn = (Connection) Conexao.getConexao();
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

			stmt.setString(1, tipoEstabelecimento.getTipoEstabelecimento());
			stmt.execute();
			stmt.close();
			conn.close();
		} catch (SQLException e){
			throw new RuntimeException (e);
		}			
	}
	
	
	public void altera(TipoEstabelecimento tipoEstabelecimento) {
	     String sql = "UPDATE tipo_estabelecimento SET tipo_estabelecimento=? WHERE id=?";
	     try {
	    	 Connection conn = (Connection) Conexao.getConexao();
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
	         stmt.setLong(2, tipoEstabelecimento.getId());
	         stmt.setString(1, tipoEstabelecimento.getTipoEstabelecimento());
	         
	         stmt.execute();
	         stmt.close();
	         conn.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
	
	
	public List <TipoEstabelecimento> getLista() {
		try {
	         List <TipoEstabelecimento> listaTipoEstabelecimento= new ArrayList <TipoEstabelecimento>();      
	         Connection conn = (Connection) Conexao.getConexao();
	         
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("select * from tipo_estabelecimento");
	         ResultSet rs = stmt.executeQuery();
	 
	         while (rs.next()) {
	      
	        	 TipoEstabelecimento tipoEstabelecimento = new TipoEstabelecimento();
	        	 tipoEstabelecimento.setId(rs.getLong("id"));
	        	 tipoEstabelecimento.setTipoEstabelecimento(rs.getString("tipo_estabelecimento"));
	        	 
	        	 listaTipoEstabelecimento.add(tipoEstabelecimento);
	         }
	         rs.close();
	         stmt.close();
	         conn.close();
	         
	         if (listaTipoEstabelecimento.isEmpty()){
		         	return null;
		         }else{
		        	return listaTipoEstabelecimento;
		         }
	         
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	}
	
	public void remove(long idTipoEstabelecimento) {
	     try {
	    	 Connection conn = (Connection) Conexao.getConexao();
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("delete" +
	                 "from tipo_estabelecimento where id=?");
	         stmt.setLong(1, idTipoEstabelecimento);
	         stmt.execute();
	         stmt.close();
	         conn.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
	
	public List <TipoEstabelecimento> getListaTipoEstabelecimentoPorIdEstabelecimento(long idEstabelecimento) {
		try {
	         List <TipoEstabelecimento> listaTipoEstabelecimento = new ArrayList <TipoEstabelecimento>();      
	         Connection conn = (Connection) Conexao.getConexao();
	         
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("SELECT tipo_estabelecimento.* "
	         		+ "FROM bd_cardapio.tipo_estabelecimento, bd_cardapio.estabelecimento_tipo_estabelecimento "
	         		+ "WHERE tipo_estabelecimento.id = estabelecimento_tipo_estabelecimento.id_tipo_estabelecimento "
	         		+ "AND estabelecimento_tipo_estabelecimento.id_estabelecimento = ?");
	         
	         stmt.setLong(1, idEstabelecimento);
	         ResultSet rs = stmt.executeQuery();
	 
	         while (rs.next()) {
	      
	        	 TipoEstabelecimento tipoEstabelecimento = new TipoEstabelecimento();
	        	 tipoEstabelecimento.setId(rs.getLong("id"));
	        	 tipoEstabelecimento.setTipoEstabelecimento(rs.getString("tipo_estabelecimento"));
	        	
	        	 listaTipoEstabelecimento.add(tipoEstabelecimento);
	         }
	         rs.close();
	         stmt.close();
	         conn.close();
	         
	         
	         if (listaTipoEstabelecimento.isEmpty()){
		         	return null;
		         }else{
		        	return listaTipoEstabelecimento;
		         }
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	}
}
