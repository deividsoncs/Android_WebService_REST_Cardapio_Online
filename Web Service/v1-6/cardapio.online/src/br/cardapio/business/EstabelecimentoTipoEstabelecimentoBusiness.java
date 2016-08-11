package br.cardapio.business;

import br.cardapio.bean.EstabelecimentoTipoEstabelecimento;
import br.cardapio.dao.EstabelecimentoTipoEstabelecimentoDAO;

public class EstabelecimentoTipoEstabelecimentoBusiness {

    // Adiciona novo Estabelecimento Tipo Estabelecimento
	public String adiciona(EstabelecimentoTipoEstabelecimento estabelecimentoTipoEstabelecimento){
		EstabelecimentoTipoEstabelecimentoDAO estabelecimentoTipoEstabelecimentoDao = new EstabelecimentoTipoEstabelecimentoDAO();
		estabelecimentoTipoEstabelecimentoDao.adiciona(estabelecimentoTipoEstabelecimento);
		return "Estabelecimento Tipo Estabelecimento inserido!";
	}
	// Remove o Estabelecimento Tipo Estabelecimento no banco através do seu ID
	public String remove(long idEstabelecimentoTipoEstabelecimento) {
		EstabelecimentoTipoEstabelecimentoDAO estabelecimentoTipoEstabelecimentoDao = new EstabelecimentoTipoEstabelecimentoDAO();
		estabelecimentoTipoEstabelecimentoDao.remove(idEstabelecimentoTipoEstabelecimento);
	    return "Estabelecimento Tipo Estabelecimento  removido!"; 
	}
	
	// Altera o Estabelecimento Tipo Estabelecimento no banco, pelos dados do objeto Serviço!
	public String alterar(EstabelecimentoTipoEstabelecimento estabelecimentoTipoEstabelecimento){
		EstabelecimentoTipoEstabelecimentoDAO estabelecimentoTipoEstabelecimentoDao = new EstabelecimentoTipoEstabelecimentoDAO();
		estabelecimentoTipoEstabelecimentoDao.altera(estabelecimentoTipoEstabelecimento);
		return "Estabelecimento Tipo Estabelecimento alterado!";
	}
}
