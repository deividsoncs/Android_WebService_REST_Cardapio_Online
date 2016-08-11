package br.cardapio.business;

import br.cardapio.bean.EstabelecimentoServico;
import br.cardapio.dao.EstabelecimentoServicoDAO;


public class EstabelecimentoServicoBusiness {
	
    // Adiciona novo Estabelecimento Servi�o
	public String adiciona(EstabelecimentoServico estabelecimentoServico){
		EstabelecimentoServicoDAO estabelecimentoServicoDao = new EstabelecimentoServicoDAO();
		estabelecimentoServicoDao.adiciona(estabelecimentoServico);
		return "Estabelecimento Servi�o inserido!";
	}
	// Remove o Estabelecimento Servi�o no banco atrav�s do seu ID
	public String remove(long idEstabelecimentoServico) {
		EstabelecimentoServicoDAO estabelecimentoServicoDao = new EstabelecimentoServicoDAO();
		estabelecimentoServicoDao.remove(idEstabelecimentoServico);
	    return "Estabelecimento Servi�o  removido!"; 
	}
	
	// Altera o Estabelecimento Servi�o no banco, pelos dados do objeto Servi�o!
	public String alterar(EstabelecimentoServico estabelecimentoServico){
		EstabelecimentoServicoDAO estabelecimentoServicoDao = new EstabelecimentoServicoDAO();
		estabelecimentoServicoDao.altera(estabelecimentoServico);
		return "Estabelecimento Servi�o alterado!";
	}
}
