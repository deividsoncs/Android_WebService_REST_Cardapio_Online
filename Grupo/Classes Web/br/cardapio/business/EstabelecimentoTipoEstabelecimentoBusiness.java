package br.cardapio.business;

import br.cardapio.bean.EstabelecimentoTipoEstabelecimento;
import br.cardapio.dao.EstabelecimentoTipoEstabelecimentoDAO;

public class EstabelecimentoTipoEstabelecimentoBusiness {

    // Adiciona novo Estabelecimento Tipo Estabelecimento
	public String adiciona(EstabelecimentoTipoEstabelecimento estabelecimentoTipoEstabelecimento){
		EstabelecimentoTipoEstabelecimentoDAO estabelecimentoTipoEstabelecimentoDao = new EstabelecimentoTipoEstabelecimentoDAO();
		if (!estabelecimentoTipoEstabelecimentoDao.jaExiste(estabelecimentoTipoEstabelecimento)){
			estabelecimentoTipoEstabelecimentoDao.adiciona(estabelecimentoTipoEstabelecimento);
			return "Tipo Estabelecimento inserido!";
		}else
			return "Tipo Estabelecimento j� cadastrado!";
	}
	// Remove o Estabelecimento Tipo Estabelecimento no banco atrav�s do seu ID
	public String remove(long idEstabelecimentoTipoEstabelecimento, long idEstabelecimento) {
		EstabelecimentoTipoEstabelecimentoDAO estabelecimentoTipoEstabelecimentoDao = new EstabelecimentoTipoEstabelecimentoDAO();
		estabelecimentoTipoEstabelecimentoDao.remove(idEstabelecimentoTipoEstabelecimento, idEstabelecimento);
	    return "Estabelecimento Tipo Estabelecimento  removido!"; 
	}
	
	// Altera o Estabelecimento Tipo Estabelecimento no banco, pelos dados do objeto Servi�o!
	public String alterar(EstabelecimentoTipoEstabelecimento estabelecimentoTipoEstabelecimento){
		EstabelecimentoTipoEstabelecimentoDAO estabelecimentoTipoEstabelecimentoDao = new EstabelecimentoTipoEstabelecimentoDAO();
		estabelecimentoTipoEstabelecimentoDao.altera(estabelecimentoTipoEstabelecimento);
		return "Estabelecimento Tipo Estabelecimento alterado!";
	}
}
