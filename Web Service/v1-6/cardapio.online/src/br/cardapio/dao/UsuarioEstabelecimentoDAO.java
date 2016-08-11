package br.cardapio.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cardapio.bean.UsuarioEstabelecimento;
import br.cardapio.recursos.Conexao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class UsuarioEstabelecimentoDAO {

	public UsuarioEstabelecimentoDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int verificaCadastrado(String cpf) {

	     int id = 0;
	     ResultSet resultSet = null;
	     PreparedStatement stmt = null;
	     Connection conn = null;
	     try {
	    	 conn = (Connection) Conexao.getConexao();
	         stmt = (PreparedStatement) conn.prepareStatement("SELECT id FROM usuario_estabelecimento WHERE id = ?");
	         stmt.setString(1, cpf);
	         resultSet = stmt.executeQuery();
	         if (resultSet.next()) {
	             id = resultSet.getInt("id");
	         }
	         stmt.close();
	    	 conn.close();
	     } catch (SQLException e) {
	         e.printStackTrace();
	     }
	     return id;
	    }
	
	public int adiciona(UsuarioEstabelecimento usuario){
		int sucesso = 0;
	    int usuariosCadastrados = verificaCadastrado(usuario.getLogin());
		
	    if (usuariosCadastrados == 0){
		    
			String sql = "insert into usuario_estabelecimento (nome, login, senha) values (?, ?, ?)";
			
			try{
				Connection conn = (Connection) Conexao.getConexao();
				PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
				
				stmt.setString(1, usuario.getNome());
				stmt.setString(2, usuario.getLogin());
				stmt.setString(3, usuario.getSenha());
				sucesso = stmt.executeUpdate();
	             if (sucesso > 0) {
	                 System.out.println("USUÁRIO INSERIDO!");
	             }
				
				stmt.close();
				conn.close();
			} catch (SQLException e){
				e.printStackTrace();
	            System.out.println("ERRO AO INSERIR USUÁRIO!");
			}
	    }else {
	         System.out.println("ERRO: USUÁRIO JÁ CADASTRADO!");
	         
	     }
	     return sucesso;
	}
	
	public List <UsuarioEstabelecimento> getLista() {
		try {
	         List <UsuarioEstabelecimento> listaUsuario = new ArrayList <UsuarioEstabelecimento>();      
	         Connection conn = (Connection) Conexao.getConexao();
	         
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("select * from usuario_estabelecimento");
	         ResultSet rs = stmt.executeQuery();
	 
	         while (rs.next()) {
	             // criando o objeto UsuarioEstabelecimento
	        	 UsuarioEstabelecimento usuario = new UsuarioEstabelecimento();
	        	 usuario.setId(rs.getLong("id"));
	        	 usuario.setNome(rs.getString("nome"));
	        	 usuario.setLogin(rs.getString("login"));
	        	 // adicionando o objeto à lista
	        	 listaUsuario.add(usuario);
	         }
	         rs.close();
	         stmt.close();
	         conn.close();
	        
	         if (listaUsuario.isEmpty()){
		         	return null;
		         }else{
		        	return listaUsuario;
		         }
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	}
	
	
	public List <UsuarioEstabelecimento> getLista(UsuarioEstabelecimento usuario) {
		try {
	         List <UsuarioEstabelecimento> listaUsuario = new ArrayList <UsuarioEstabelecimento>();      
	         Connection conn = (Connection) Conexao.getConexao();
	         
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("select * from usuario_estabelecimento "
	         		+ "where usuario_estabelecimento.nome LIKE ?");
	         stmt.setString(1, "%" + usuario.getNome() + "%");
	         ResultSet rs = stmt.executeQuery();
	 
	         while (rs.next()) {
	             // criando o objeto UsuarioEstabelecimento
	        	 usuario = new UsuarioEstabelecimento();
	        	 usuario.setId(rs.getLong("id"));
	        	 usuario.setNome(rs.getString("nome"));
	        	 usuario.setLogin(rs.getString("login"));
	        	 // adicionando o objeto à lista
	        	 listaUsuario.add(usuario);
	         }
	         rs.close();
	         stmt.close();
	         conn.close();
	         if (listaUsuario.isEmpty()){
		         	return null;
		         }else{
		        	return listaUsuario;
		         }
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	}
	
	
	public int altera(UsuarioEstabelecimento usuario) {
	     String sql = "update usuario_estabelecimento set nome=?, login=?, senha=?," +
	             "where id=?";
	     int sucesso = 0;
	     try {
	    	 Connection conn = (Connection) Conexao.getConexao();
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
	         stmt.setString(1, usuario.getNome());
	         stmt.setString(2, usuario.getLogin());
	         stmt.setString(3, usuario.getSenha());
	         stmt.setLong(4, usuario.getId());
	         
	         sucesso = stmt.executeUpdate();
	         if (sucesso > 0) {
	             System.out.println("USUÁRIO ALTERADO!");
	         } else {
	             System.out.println("USUÁRIO NÃO EXISTE!");
	         }
	         stmt.close();
	         conn.close();
	     } catch (SQLException e) {
	    	 e.printStackTrace();
	         System.out.println("ERRO AO ALTERAR CLIENTE!");
	     }
	     return sucesso;
	 }

	
	 public int remove(long idUsuario) {
		 int excluidos = 0;
	     try {
	    	 Connection conn = (Connection) Conexao.getConexao();
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("DELETE FROM bd_cardapio.usuario_estabelecimento "
	         		+ "WHERE id=?");
	         stmt.setLong(1, idUsuario);
	         excluidos = stmt.executeUpdate();
	
	         stmt.close();
	         conn.close();
	     } catch (SQLException e) {
	    	 e.printStackTrace();
	         System.out.println("ERRO AO DELETAR USUÁRIO!");
	     }
	     return excluidos;
	 }
	
	
}
