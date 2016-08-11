package br.cardapio.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.cardapio.bean.Estabelecimento;
import br.cardapio.listas.EstabelecimentoList;
import br.cardapio.recursos.Conexao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class EstabelecimentoDAO {
	
	
	public void adiciona(Estabelecimento estabelecimento){
		String sql = "INSERT INTO estabelecimento "
				+ "(id_usuario, nome_fantasia, email, telefone, razao_social, gostaram, foto) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try{
			Connection conn = (Connection) Conexao.getConexao();
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
			
			stmt.setLong(1, estabelecimento.getIdUsuario());
			stmt.setString(2, estabelecimento.getNomeFantasia());
			stmt.setString(3, estabelecimento.getEmail());
			stmt.setString(4, estabelecimento.getTelefone());
			stmt.setString(5, estabelecimento.getRazaoSocial());
			stmt.setInt(6, estabelecimento.getGostaram());
			stmt.setString(7, estabelecimento.getFoto());

			stmt.execute();
			stmt.close();
			conn.close();
		} catch (SQLException e){
			throw new RuntimeException (e);
		}			
	}
	
	
	public void altera(Estabelecimento estabelecimento) {
	     String sql = "UPDATE bd_cardapio.estabelecimento SET id_usuario=?, nome_fantasia=?, email=?, telefone=?, razao_social=?, gostaram=?, foto=?" +
	             "WHERE id=?";
	     try {
	    	 Connection conn = (Connection) Conexao.getConexao();
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
	         stmt.setLong(1, estabelecimento.getIdUsuario());
	         stmt.setString(2, estabelecimento.getNomeFantasia());
	         stmt.setString(3, estabelecimento.getEmail());
	         stmt.setString(4, estabelecimento.getTelefone());
	         stmt.setString(5, estabelecimento.getRazaoSocial());
	         stmt.setLong(6, estabelecimento.getGostaram());
	         stmt.setString(7, estabelecimento.getFoto());
	  
	         
	         stmt.setLong(8, estabelecimento.getId());
	         
	         stmt.execute();
	         stmt.close();
	         conn.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
	
	
	public EstabelecimentoList getLista() {
		try {
	         EstabelecimentoList listaEstabelecimentos = new EstabelecimentoList();      
	         Connection conn = (Connection) Conexao.getConexao();
	         
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("SELECT * FROM bd_cardapio.estabelecimento");
	         ResultSet rs = stmt.executeQuery();
	 
	         while (rs.next()) {
	      
	        	 Estabelecimento estabelecimento = new Estabelecimento();
	        	 estabelecimento.setId(rs.getLong("id"));
	        	 estabelecimento.setIdUsuario(rs.getLong("id_usuario"));
	        	 estabelecimento.setNomeFantasia(rs.getString("nome_fantasia"));
	        	 estabelecimento.setEmail(rs.getString("email"));
	        	 estabelecimento.setTelefone(rs.getString("telefone"));
	        	 estabelecimento.setRazaoSocial(rs.getString("razao_social"));
	        	 estabelecimento.setGostaram(rs.getInt("gostaram"));
	        	 estabelecimento.setFoto(rs.getString("foto"));
	        	 
	        	 
	        	 listaEstabelecimentos.add(estabelecimento);
	         }
	         rs.close();
	         stmt.close();
	         conn.close();
	         
	       
	         return listaEstabelecimentos;
		     
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	}
	
	
	public void remove(long idEstabelecimento) {
	     try {
	    	 Connection conn = (Connection) Conexao.getConexao();
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("DELETE FROM bd_cardapio.estabelecimento "
	         		+ "WHERE id=?");
	         stmt.setLong(1, idEstabelecimento);
	         stmt.execute();
	         stmt.close();
	         conn.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
	
	// Lista todos Estabelecimentos pelos id do TipoEstabelecimento passado! Ex.: Lista de Estabelecimentos que são churrascarias.
	public EstabelecimentoList getListaPorTipoEstabelecimento(long id) {
		try {
			EstabelecimentoList listaEstabelecimentos = new EstabelecimentoList();      
	         Connection conn = (Connection) Conexao.getConexao();
	         
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("SELECT estabelecimento.* "
	         		+ "FROM bd_cardapio.estabelecimento, bd_cardapio.estabelecimento_tipo_estabelecimento "
	         		+ "WHERE estabelecimento.id = estabelecimento_tipo_estabelecimento.id_estabelecimento and "
	         		+ "estabelecimento_tipo_estabelecimento.id_tipo_estabelecimento = ?");
	         
	         stmt.setLong(1, id);
	         ResultSet rs = stmt.executeQuery();
	 
	         while (rs.next()) {
	      
	        	 Estabelecimento estabelecimento = new Estabelecimento();
	        	 estabelecimento.setId(rs.getLong("id"));
	        	 estabelecimento.setIdUsuario(rs.getLong("id_usuario"));
	        	 estabelecimento.setNomeFantasia(rs.getString("nome_fantasia"));
	        	 estabelecimento.setEmail(rs.getString("email"));
	        	 estabelecimento.setTelefone(rs.getString("telefone"));
	        	 estabelecimento.setRazaoSocial(rs.getString("razao_social"));
	        	 estabelecimento.setGostaram(rs.getInt("gostaram")); // observar o INT!
	        	 estabelecimento.setFoto(rs.getString("foto"));
	        	 
	        	 listaEstabelecimentos.add(estabelecimento);
	         }
	         rs.close();
	         stmt.close();
	         conn.close();
		     return listaEstabelecimentos;
		     
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	}
	

	
	// Retornar a lista dos Estabelecimentos passando a ID do Serviços selecionado, ex.: Todos estabelecimento que possuem "música ao vivo"
	public EstabelecimentoList getListaPorServicos(long id) {
		try {
			EstabelecimentoList listaEstabelecimentos = new EstabelecimentoList();      
	         Connection conn = (Connection) Conexao.getConexao();
	         
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("SELECT estabelecimento.* "
	         		+ "FROM bd_cardapio.estabelecimento, bd_cardapio.estabelecimento_servicos, bd_cardapio.servicos "
	         		+ "WHERE estabelecimento.id = estabelecimento_servicos.id_estabelecimento "
	         		+ "AND estabelecimento_servicos.id_servico = servicos.id AND estabelecimento_servicos.id_servico = ?");
	         
	         stmt.setLong(1, id);
	         ResultSet rs = stmt.executeQuery();
	 
	         while (rs.next()) {
	      
	        	 Estabelecimento estabelecimento = new Estabelecimento();
	        	 estabelecimento.setId(rs.getLong("id"));
	        	 estabelecimento.setIdUsuario(rs.getLong("id_usuario"));
	        	 estabelecimento.setNomeFantasia(rs.getString("nome_fantasia"));
	        	 estabelecimento.setEmail(rs.getString("email"));
	        	 estabelecimento.setTelefone(rs.getString("telefone"));
	        	 estabelecimento.setRazaoSocial(rs.getString("razao_social"));
	        	 estabelecimento.setGostaram(rs.getInt("gostaram")); // observar o INT!
	        	 estabelecimento.setFoto(rs.getString("foto"));
	        	 
	        	 listaEstabelecimentos.add(estabelecimento);
	         }
	         rs.close();
	         stmt.close();
	         conn.close();
	         
	         return listaEstabelecimentos;
	         
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	}
	
    // Retornar a lista dos Estabelecimentos passando a a Cidade
	public EstabelecimentoList getListaPorCidades(String cidade) {
		try {
	         EstabelecimentoList listaEstabelecimentos = new EstabelecimentoList();      
	         Connection conn = (Connection) Conexao.getConexao();
	         
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("SELECT estabelecimento.* "
	         		+ "FROM bd_cardapio.estabelecimento, bd_cardapio.endereco "
	         		+ "WHERE estabelecimento.id = endereco.id_estabelecimento AND endereco.cidade LIKE ?");
	         
	         stmt.setString(1, "%" + cidade + "%");
	         ResultSet rs = stmt.executeQuery();
	 
	         while (rs.next()) {
	      
	        	 Estabelecimento estabelecimento = new Estabelecimento();
	        	 estabelecimento.setId(rs.getLong("id"));
	        	 estabelecimento.setIdUsuario(rs.getLong("id_usuario"));
	        	 estabelecimento.setNomeFantasia(rs.getString("nome_fantasia"));
	        	 estabelecimento.setEmail(rs.getString("email"));
	        	 estabelecimento.setTelefone(rs.getString("telefone"));
	        	 estabelecimento.setRazaoSocial(rs.getString("razao_social"));
	        	 estabelecimento.setGostaram(rs.getInt("gostaram")); // observar o INT!
	        	 estabelecimento.setFoto(rs.getString("foto"));
	        	 
	        	 listaEstabelecimentos.add(estabelecimento);
	         }
	         rs.close();
	         stmt.close();
	         conn.close();
	         
	         return listaEstabelecimentos;
	         
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	}

	// Retornar a lista dos Estabelecimentos passando o Nome do Estabelecimento
	public EstabelecimentoList getListaPorNome(String nomeEstabelecimento) {
		try {
			EstabelecimentoList listaEstabelecimentos = new EstabelecimentoList();      
	         Connection conn = (Connection) Conexao.getConexao();
	         
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("SELECT estabelecimento.* "
	         		+ "FROM bd_cardapio.estabelecimento WHERE estabelecimento.nome_fantasia LIKE ?");
	         
	         stmt.setString(1, "%" + nomeEstabelecimento + "%");
	         ResultSet rs = stmt.executeQuery();
	 
	         while (rs.next()) {
	      
	        	 Estabelecimento estabelecimento = new Estabelecimento();
	        	 estabelecimento.setId(rs.getLong("id"));
	        	 estabelecimento.setIdUsuario(rs.getLong("id_usuario"));
	        	 estabelecimento.setNomeFantasia(rs.getString("nome_fantasia"));
	        	 estabelecimento.setEmail(rs.getString("email"));
	        	 estabelecimento.setTelefone(rs.getString("telefone"));
	        	 estabelecimento.setRazaoSocial(rs.getString("razao_social"));
	        	 estabelecimento.setGostaram(rs.getInt("gostaram")); // observar o INT!
	        	 estabelecimento.setFoto(rs.getString("foto"));
	        	 
	        	 listaEstabelecimentos.add(estabelecimento);
	         }
	         rs.close();
	         stmt.close();
	         conn.close();


	         return listaEstabelecimentos;
	         
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	}
	
	
	// Retornar a lista dos Estabelecimentos passando o Login
	public EstabelecimentoList getListaPorLogin(String login) {
		try {
			EstabelecimentoList listaEstabelecimentos = new EstabelecimentoList();      
	         Connection conn = (Connection) Conexao.getConexao();
	         
	         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("SELECT estabelecimento.* "
	         		+ "FROM bd_cardapio.estabelecimento, bd_cardapio.usuario_estabelecimento "
	         		+ "WHERE estabelecimento.id_usuario = usuario_estabelecimento.id AND usuario_estabelecimento.login = ?");
	         
	         stmt.setString(1, login);
	         ResultSet rs = stmt.executeQuery();
	 
	         while (rs.next()) {
	      
	        	 Estabelecimento estabelecimento = new Estabelecimento();
	        	 estabelecimento.setId(rs.getLong("id"));
	        	 estabelecimento.setIdUsuario(rs.getLong("id_usuario"));
	        	 estabelecimento.setNomeFantasia(rs.getString("nome_fantasia"));
	        	 estabelecimento.setEmail(rs.getString("email"));
	        	 estabelecimento.setTelefone(rs.getString("telefone"));
	        	 estabelecimento.setRazaoSocial(rs.getString("razao_social"));
	        	 estabelecimento.setGostaram(rs.getInt("gostaram")); // observar o INT!
	        	 estabelecimento.setFoto(rs.getString("foto"));
	        	 
	        	 listaEstabelecimentos.add(estabelecimento);
	         }
	         rs.close();
	         stmt.close();
	         conn.close();


	         return listaEstabelecimentos;
	         
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	}
	
	// Retornar a lista dos Estabelecimentos que tem algum ITEM de seu cardápio em PROMOÇÃO
		public EstabelecimentoList getListaPorPromocao() {
			try {
				EstabelecimentoList listaEstabelecimentos = new EstabelecimentoList();      
		         Connection conn = (Connection) Conexao.getConexao();
		         
		         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("SELECT estabelecimento.* "
		         		+ "FROM bd_cardapio.estabelecimento, bd_cardapio.cardapio, bd_cardapio.secao_cardapio, "
		         		+ "bd_cardapio.item_cardapio WHERE estabelecimento.id = cardapio.id_estabelecimento "
		         		+ "AND cardapio.id = secao_cardapio.id_cardapio AND secao_cardapio.id = item_cardapio.id_secao_cardapio "
		         		+ "AND item_cardapio.percentual_desconto IS NOT NULL");

		         ResultSet rs = stmt.executeQuery();
		 
		         while (rs.next()) {
		      
		        	 Estabelecimento estabelecimento = new Estabelecimento();
		        	 estabelecimento.setId(rs.getLong("id"));
		        	 estabelecimento.setIdUsuario(rs.getLong("id_usuario"));
		        	 estabelecimento.setNomeFantasia(rs.getString("nome_fantasia"));
		        	 estabelecimento.setEmail(rs.getString("email"));
		        	 estabelecimento.setTelefone(rs.getString("telefone"));
		        	 estabelecimento.setRazaoSocial(rs.getString("razao_social"));
		        	 estabelecimento.setGostaram(rs.getInt("gostaram"));
		        	 estabelecimento.setFoto(rs.getString("foto"));
		        	 
		        	 listaEstabelecimentos.add(estabelecimento);
		         }
		         rs.close();
		         stmt.close();
		         conn.close();


		         return listaEstabelecimentos;
		         
		     } catch (SQLException e) {
		         throw new RuntimeException(e);
		     }
		}
		
		// Retornar o estabelecimento pelo ID
		public Estabelecimento getEstabelecimentoPorId(long id) {
			try {
		         Estabelecimento estabelecimento = new Estabelecimento();      
		         Connection conn = (Connection) Conexao.getConexao();
		         
		         PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("SELECT estabelecimento.* "
		         		+ "FROM bd_cardapio.estabelecimento WHERE estabelecimento.id = ?");
		         
		         stmt.setLong(1, id);
		         ResultSet rs = stmt.executeQuery();
		         
		         while (rs.next()) {
		      
		        	 estabelecimento.setId(rs.getLong("id"));
		        	 estabelecimento.setIdUsuario(rs.getLong("id_usuario"));
		        	 estabelecimento.setNomeFantasia(rs.getString("nome_fantasia"));
		        	 estabelecimento.setEmail(rs.getString("email"));
		        	 estabelecimento.setTelefone(rs.getString("telefone"));
		        	 estabelecimento.setRazaoSocial(rs.getString("razao_social"));
		        	 estabelecimento.setGostaram(rs.getInt("gostaram")); // observar o INT!
		        	 estabelecimento.setFoto(rs.getString("foto"));
		
		         }
		         rs.close();
		         stmt.close();
		         conn.close();
		         if (estabelecimento.getId() > 0){
		        	 return estabelecimento;
		         }else{
		        	 return null;
		         }
		         
		     } catch (SQLException e) {
		         throw new RuntimeException(e);
		     }
		}
}
