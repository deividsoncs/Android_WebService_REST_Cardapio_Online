package br.cardapio.dao;

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

	
	 public void remove(long idEstabelecimentoServico) {
	     try {
	    	 Connection conn = (Connection) Conexao.getConexao();
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("DELETE FROM estabelecimento_servicos WHERE id=?");
	         stmt.setLong(1, idEstabelecimentoServico);
	         stmt.execute();
	         stmt.close();
	         conn.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
}
