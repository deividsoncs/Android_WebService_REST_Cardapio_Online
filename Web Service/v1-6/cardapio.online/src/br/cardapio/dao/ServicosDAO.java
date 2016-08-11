package br.cardapio.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cardapio.bean.Servicos;
import br.cardapio.recursos.Conexao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ServicosDAO {

	public ServicosDAO() {
		super();
	}
	
	public void adiciona(Servicos servico){

		String sql = "INSERT INTO servicos " + 
					"(descricao) VALUES (?)";
		
		try{
			Connection conn = (Connection) Conexao.getConexao();
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

			stmt.setString(1, servico.getDescricao());
			
			stmt.execute();
			stmt.close();
			conn.close();
		} catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public List <Servicos> getLista() {
		try {
	         List <Servicos> listaServicos = new ArrayList <Servicos>();      
	         Connection conn = (Connection) Conexao.getConexao();
	         
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("SELECT * FROM servicos");
	         ResultSet rs = stmt.executeQuery();
	 
	         while (rs.next()) {
	      
	        	 Servicos servico = new Servicos();
	        	 servico.setId(rs.getLong("id"));
	        	 servico.setDescricao(rs.getString("descricao"));
	        	
	        	 listaServicos.add(servico);
	         }
	         rs.close();
	         stmt.close();
	         conn.close();
	         
	         
	         if (listaServicos.isEmpty()){
		         	return null;
		         }else{
		        	return listaServicos;
		         }
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	}
	
	
	public void altera(Servicos servico) {
	     String sql = "UPDATE servicos SET descricao=? WHERE id=?";
	     try {
	    	 Connection conn = (Connection) Conexao.getConexao();
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
	         stmt.setString(1, servico.getDescricao());
	         stmt.setLong(2, servico.getId());
	         
	         stmt.execute();
	         stmt.close();
	         conn.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }

	
	 public void remove(long idServico) {
	     try {
	    	 Connection conn = (Connection) Conexao.getConexao();
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("DELETE FROM servicos WHERE id=?");
	         stmt.setLong(1, idServico);
	         stmt.execute();
	         stmt.close();
	         conn.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }

	public List<Servicos> getListaServicosPorIdEstabelecimento(long idEstabelecimento) {
		try {
	         List <Servicos> listaServicos = new ArrayList <Servicos>();      
	         Connection conn = (Connection) Conexao.getConexao();
	         
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("SELECT servicos.* "
	         		+ "FROM bd_cardapio.servicos, bd_cardapio.estabelecimento_servicos "
	         		+ "WHERE servicos.id = estabelecimento_servicos.id_servico "
	         		+ "AND estabelecimento_servicos.id_estabelecimento = ?");
	         
	         stmt.setLong(1, idEstabelecimento);
	         ResultSet rs = stmt.executeQuery();
	 
	         while (rs.next()) {
	      
	        	 Servicos servico = new Servicos();
	        	 servico.setId(rs.getLong("id"));
	        	 servico.setDescricao(rs.getString("descricao"));
	        	
	        	 listaServicos.add(servico);
	         }
	         rs.close();
	         stmt.close();
	         conn.close();
	         
	         
	         if (listaServicos.isEmpty()){
		         	return null;
		         }else{
		        	return listaServicos;
		         }
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	}
}
