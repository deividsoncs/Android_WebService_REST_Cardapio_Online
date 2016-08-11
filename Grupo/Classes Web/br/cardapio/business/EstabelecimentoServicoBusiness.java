package br.cardapio.business;

import br.cardapio.bean.EstabelecimentoServico;
import br.cardapio.dao.EstabelecimentoServicoDAO;


public class EstabelecimentoServicoBusiness {
	
    // Adiciona novo Estabelecimento Servi�o
	public String adiciona(EstabelecimentoServico estabelecimentoServico){
		EstabelecimentoServicoDAO estabelecimentoServicoDao = new EstabelecimentoServicoDAO();
		if (estabelecimentoServicoDao.jaExiste(estabelecimentoServico)==false){
			estabelecimentoServicoDao.adiciona(estabelecimentoServico);
			return "Servico inserido!";
		}else
			return "Servico j� cadastrado!";
	}
	// Remove o Estabelecimento Servi�o no banco atrav�s do seu ID
	public String remove(long idEstabelecimento, long idServico) {
		EstabelecimentoServicoDAO estabelecimentoServicoDao = new EstabelecimentoServicoDAO();
		estabelecimentoServicoDao.remove(idEstabelecimento, idServico);
	    return "Estabelecimento Servi�o  removido!"; 
	}
	
	// Altera o Estabelecimento Servi�o no banco, pelos dados do objeto Servi�o!
	public String alterar(EstabelecimentoServico estabelecimentoServico){
		EstabelecimentoServicoDAO estabelecimentoServicoDao = new EstabelecimentoServicoDAO();
		estabelecimentoServicoDao.altera(estabelecimentoServico);
		return "Estabelecimento Servi�o alterado!";
	}
}
