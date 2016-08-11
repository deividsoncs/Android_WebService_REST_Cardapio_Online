package br.cardapio.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.cardapio.bean.Estabelecimento;
import br.cardapio.bean.EstabelecimentoTipoEstabelecimento;
import br.cardapio.recursos.Conexao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class EstabelecimentoTipoEstabelecimentoDAO {

	public void adiciona(EstabelecimentoTipoEstabelecimento estabelecimentoTipoEstabelecimento){

		String sql = "INSERT INTO bd_cardapio.estabelecimento_tipo_estabelecimento "
				+ "(id_estabelecimento, id_tipo_estabelecimento) VALUES (?, ?)";
		
		try{
			Connection conn = (Connection) Conexao.getConexao();
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
			
			stmt.setLong(1, estabelecimentoTipoEstabelecimento.getIdEstabelecimento());
			stmt.setLong(2, estabelecimentoTipoEstabelecimento.getIdTipoEstabelecimento());
			
			stmt.execute();
			stmt.close();
			conn.close();
		} catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public void altera(EstabelecimentoTipoEstabelecimento estabelecimentoTipoEstabelecimento) {
	     String sql = "UPDATE bd_cardapio.estabelecimento_tipo_estabelecimento "
	     		+ "SET id_estabelecimento=?, id_tipo_estabelecimento=? WHERE id=?";
	     try {
	    	 Connection conn = (Connection) Conexao.getConexao();
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
	         stmt.setLong(1, estabelecimentoTipoEstabelecimento.getIdEstabelecimento());
	         stmt.setLong(2, estabelecimentoTipoEstabelecimento.getIdTipoEstabelecimento());
	         stmt.setLong(3, estabelecimentoTipoEstabelecimento.getId());
	         
	         stmt.execute();
	         stmt.close();
	         conn.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }

	
	 public void remove(long idTipoEstabelecimento, long idEstabelecimento) {
	     try {
	    	 Connection conn = (Connection) Conexao.getConexao();
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("DELETE "
	         		+ "FROM bd_cardapio.estabelecimento_tipo_estabelecimento WHERE id_tipo_estabelecimento=? AND id_estabelecimento=?");
	         stmt.setLong(1, idTipoEstabelecimento);
	         stmt.setLong(2, idEstabelecimento);
	         stmt.execute();
	         stmt.close();
	         conn.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
	 
	 public boolean jaExiste(EstabelecimentoTipoEstabelecimento estabelecimentoTipo){
		 boolean achou=false;
		 Connection conn = (Connection) Conexao.getConexao();
         PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) conn.prepareStatement("SELECT estabelecimento_tipo_estabelecimento.* "
			 		+ "FROM bd_cardapio.estabelecimento_tipo_estabelecimento "
			 		+ "WHERE estabelecimento_tipo_estabelecimento.id_estabelecimento = ? AND estabelecimento_tipo_estabelecimento.id_tipo_estabelecimento = ?");
		
	         stmt.setLong(1, estabelecimentoTipo.getIdEstabelecimento());
	         stmt.setLong(2, estabelecimentoTipo.getIdTipoEstabelecimento());
	         ResultSet rs = stmt.executeQuery();
	         while (rs.next()) {
	        	 achou=true;
	        	 break;
	         }
	         rs.close();
	         stmt.close();
	         conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
         if (achou)
        	 return true;
         return achou;
	 }
}
