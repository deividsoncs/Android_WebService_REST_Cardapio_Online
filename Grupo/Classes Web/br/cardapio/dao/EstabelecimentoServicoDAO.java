package br.cardapio.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.cardapio.bean.EstabelecimentoServico;
import br.cardapio.recursos.Conexao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class EstabelecimentoServicoDAO {
	
	public EstabelecimentoServicoDAO() {
		super();
	}
	
	public void adiciona(EstabelecimentoServico estabelecimentoServico){

		String sql = "INSERT INTO estabelecimento_servicos " + 
					"(id_estabelecimento, id_servico) VALUES (?, ?)";
		
		try{
			Connection conn = (Connection) Conexao.getConexao();
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
			
			stmt.setLong(1, estabelecimentoServico.getIdEstabelecimento());
			stmt.setLong(2, estabelecimentoServico.getIdServico());
			
			stmt.execute();
			stmt.close();
			conn.close();
		} catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public void altera(EstabelecimentoServico estabelecimentoServico) {
	     String sql = "UPDATE estabelecimento_servicos SET id_estabelecimento=?, id_servico=? WHERE id=?";
	     try {
	    	 Connection conn = (Connection) Conexao.getConexao();
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
	         stmt.setLong(1, estabelecimentoServico.getIdEstabelecimento());
	         stmt.setLong(2, estabelecimentoServico.getIdServico());
	         stmt.setLong(3, estabelecimentoServico.getId());
	         
	         stmt.execute();
	         stmt.close();
	         conn.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }

	
	 public void remove(long idEstabelecimento, long idServico) {
	     try {
	    	 Connection conn = (Connection) Conexao.getConexao();
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("DELETE FROM estabelecimento_servicos "
	         		+ "WHERE id_estabelecimento=? AND id_servico=?");
	         stmt.setLong(1, idEstabelecimento);
	         stmt.setLong(2, idServico);
	         stmt.execute();
	         stmt.close();
	         conn.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
	 
	 public boolean jaExiste(EstabelecimentoServico estabelecimentoServico){
		 boolean achou=false;
		 Connection conn = (Connection) Conexao.getConexao();
         PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) conn.prepareStatement("SELECT estabelecimento_servicos.* "
			 		+ "FROM bd_cardapio.estabelecimento_servicos "
			 		+ "WHERE estabelecimento_servicos.id_estabelecimento = ? AND estabelecimento_servicos.id_servico = ?");
		
	         stmt.setLong(1, estabelecimentoServico.getIdEstabelecimento());
	         stmt.setLong(2, estabelecimentoServico.getIdServico());
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
         return false;
	 }
}
