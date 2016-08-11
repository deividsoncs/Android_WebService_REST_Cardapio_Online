package br.cardapio.dao;

import java.sql.SQLException;

import br.cardapio.bean.EstabelecimentoTipoEstabelecimento;
import br.cardapio.recursos.Conexao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class EstabelecimentoTipoEstabelecimentoDAO {

	public void adiciona(EstabelecimentoTipoEstabelecimento estabelecimentoTipoEstabelecimento){

		String sql = "INSERT INTO estabelecimento_tipo_estabelecimento "
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
	     String sql = "UPDATE estabelecimento_tipo_estabelecimento "
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

	
	 public void remove(long idTipoEstabelecimento) {
	     try {
	    	 Connection conn = (Connection) Conexao.getConexao();
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("DELETE "
	         		+ "FROM estabelecimento_servicos WHERE id=?");
	         stmt.setLong(1, idTipoEstabelecimento);
	         stmt.execute();
	         stmt.close();
	         conn.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
}
