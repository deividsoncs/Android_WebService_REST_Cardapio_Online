package br.cardapio.business;

import br.cardapio.bean.UsuarioEstabelecimento;
import br.cardapio.dao.UsuarioEstabelecimentoDAO;
import br.cardapio.listas.UsuarioEstabelecimentoList;

public class UsuarioEstabelecimentoBusiness {

	public String adiciona(UsuarioEstabelecimento usuario){
		UsuarioEstabelecimentoDAO usuarioDao = new UsuarioEstabelecimentoDAO();
		if (usuarioDao.adiciona(usuario) > 0){
			return "Usu�rio Inserido com Sucesso!";
		}else{
			return "Falha ao Inserir Usu�rio!";
		}
	}
	
	//Deleta o usu�rio no banco atrav�s do seu ID
	public String remove(long idUsuario) {
		 UsuarioEstabelecimentoDAO usuarioDao = new UsuarioEstabelecimentoDAO();
	     if(usuarioDao.remove(idUsuario) > 0){
	         return "Usu�rio removido no banco com sucesso!";
	     } else {
	         return "Usu�rio n�o existe!";
	     }
	}
	
	//Altera o usu�rio no banco, pelos dados do objeto usu�rio!
	public String alterar(UsuarioEstabelecimento usuario){
		UsuarioEstabelecimentoDAO usuarioDao = new UsuarioEstabelecimentoDAO();
		if(usuarioDao.altera(usuario) > 0){
	         return "Altera��o de Usuario realizasa no banco com sucesso!";
	     } else {
	         return "Usu�rio n�o existe!";
	     }
	}
	
	//Busca todos usu�rios da tabela usuario_estabelecimento
	public UsuarioEstabelecimentoList getListaTodosUsuarios(){
		  UsuarioEstabelecimentoDAO usuarioDao = new UsuarioEstabelecimentoDAO();
		  return usuarioDao.getLista();
	}
	
	//Busca o usu�rio pelo NOME
	public UsuarioEstabelecimentoList getUsuario(String nomeUsuario){
		  UsuarioEstabelecimentoList listaUsuario = new UsuarioEstabelecimentoList(); 
		  
		  UsuarioEstabelecimento usuario = new UsuarioEstabelecimento();
		  UsuarioEstabelecimentoDAO usuarioDao = new UsuarioEstabelecimentoDAO();
		  
		  usuario.setNome(nomeUsuario);
		  listaUsuario = usuarioDao.getLista(usuario);
		  return listaUsuario;
	  }

	public UsuarioEstabelecimento autentica(UsuarioEstabelecimento usuario) {
		  UsuarioEstabelecimentoDAO usuarioDao = new UsuarioEstabelecimentoDAO();
		  return usuarioDao.autentica(usuario);	 
	}
	
	
}
