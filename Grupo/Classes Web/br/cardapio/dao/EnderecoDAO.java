package br.cardapio.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import br.cardapio.bean.Endereco;
import br.cardapio.recursos.Conexao;

public class EnderecoDAO {

	public EnderecoDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public void adiciona(Endereco endereco){
		String sql = "INSERT INTO bd_cardapio.endereco "
				+ "(id_estabelecimento, cep, numero, complemento, logradouro, estado, cidade, bairro) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	
		try{
			Connection conn = (Connection) Conexao.getConexao();
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
			
			stmt.setLong(1, endereco.getIdEstabelecimento());
			stmt.setString(2, endereco.getCep());
			stmt.setInt(3, endereco.getNumero());
			stmt.setString(4, endereco.getComplemento());
			stmt.setString(5, endereco.getLogradouro());
			stmt.setString(6, endereco.getEstado());
			stmt.setString(7, endereco.getCidade());
			stmt.setString(8, endereco.getBairro());
			
			stmt.execute();
			stmt.close();
			conn.close();
		} catch (SQLException e){
			throw new RuntimeException (e);
		}			
	}
	
	
	public void altera(Endereco endereco) {
	     String sql = "UPDATE bd_cardapio.endereco "
	     		+ "SET id_estabelecimento=?, cep=?, numero=?, complemento=?, logradouro=?, estado=?, cidade=?, bairro=? "
	     		+ "WHERE id=?";
	     try {
	    	 Connection conn = (Connection) Conexao.getConexao();
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
	         stmt.setLong(1, endereco.getIdEstabelecimento());
	         stmt.setString(2, endereco.getCep());
	         stmt.setInt(3, endereco.getNumero());
	         stmt.setString(4, endereco.getComplemento());
	         stmt.setString(5, endereco.getLogradouro());
	         stmt.setString(6, endereco.getEstado());
	         stmt.setString(7, endereco.getCidade());
	         stmt.setString(8, endereco.getBairro());
	         
	         stmt.setLong(9, endereco.getId());
	         
	         stmt.execute();
	         stmt.close();
	         conn.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
	
	public void remove(long idEndereco) {
	     try {
	    	 Connection conn = (Connection) Conexao.getConexao();
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("DELETE "
	         		+ "FROM bd_cardapio.endereco WHERE id=?");
	         stmt.setLong(1, idEndereco);
	         stmt.execute();
	         stmt.close();
	         conn.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
	
	// Retorna o Endereço referente a id do Estabelecimento Passado
	public Endereco getEnderecoPorIdEstabelecimento(long idEstabelecimento) {
		try {
	           
	         Connection conn = (Connection) Conexao.getConexao();
	         
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("SELECT endereco.* "
	         		+ "FROM bd_cardapio.endereco WHERE endereco.id_estabelecimento = ?");
	         
	         stmt.setLong(1, idEstabelecimento);
	         ResultSet rs = stmt.executeQuery();
	         Endereco endereco = new Endereco();
	         endereco.setId(0);
	         while (rs.next()) {
	        	 endereco.setId(rs.getLong("id"));
	        	 endereco.setIdEstabelecimento(rs.getLong("id_estabelecimento"));
	        	 endereco.setCep(rs.getString("cep"));
	        	 endereco.setNumero(rs.getInt("numero"));
	        	 endereco.setComplemento(rs.getString("complemento"));
	        	 endereco.setLogradouro(rs.getString("logradouro"));
	        	 endereco.setEstado(rs.getString("estado"));
	        	 endereco.setCidade(rs.getString("cidade"));
	        	 endereco.setBairro(rs.getString("bairro"));
	         }
	         
	         rs.close();
	         stmt.close();
	         conn.close();
	         
	         return endereco;
	       
	        
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	}  
}
