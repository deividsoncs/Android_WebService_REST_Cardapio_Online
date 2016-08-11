package br.cardapio.business;



import java.util.ArrayList;
import java.util.List;

import br.cardapio.bean.UsuarioEstabelecimento;
import br.cardapio.dao.UsuarioEstabelecimentoDAO;

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
	
	//Busca todos usu�rios da tabelela usuario_estabelecimento
	public List <UsuarioEstabelecimento> getListaTodosUsuarios(){
		  List <UsuarioEstabelecimento> listaUsuario = new ArrayList <UsuarioEstabelecimento>(); 
		  UsuarioEstabelecimentoDAO usuarioDao = new UsuarioEstabelecimentoDAO();
		  listaUsuario = usuarioDao.getLista();
		  return listaUsuario;
	  }
	
	//Busca o usu�rio pelo NOME
	public List <UsuarioEstabelecimento> getUsuario(String nomeUsuario){
		  List <UsuarioEstabelecimento> listaUsuario = new ArrayList <UsuarioEstabelecimento>(); 
		  
		  UsuarioEstabelecimento usuario = new UsuarioEstabelecimento();
		  UsuarioEstabelecimentoDAO usuarioDao = new UsuarioEstabelecimentoDAO();
		  
		  usuario.setNome(nomeUsuario);
		  listaUsuario = usuarioDao.getLista(usuario);
		  return listaUsuario;
	  }
	
	
}
