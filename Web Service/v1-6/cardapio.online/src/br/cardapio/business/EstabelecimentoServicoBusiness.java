package br.cardapio.business;

import br.cardapio.bean.EstabelecimentoServico;
import br.cardapio.dao.EstabelecimentoServicoDAO;


public class EstabelecimentoServicoBusiness {
	
    // Adiciona novo Estabelecimento Serviço
	public String adiciona(EstabelecimentoServico estabelecimentoServico){
		EstabelecimentoServicoDAO estabelecimentoServicoDao = new EstabelecimentoServicoDAO();
		estabelecimentoServicoDao.adiciona(estabelecimentoServico);
		return "Estabelecimento Serviço inserido!";
	}
	// Remove o Estabelecimento Serviço no banco através do seu ID
	public String remove(long idEstabelecimentoServico) {
		EstabelecimentoServicoDAO estabelecimentoServicoDao = new EstabelecimentoServicoDAO();
		estabelecimentoServicoDao.remove(idEstabelecimentoServico);
	    return "Estabelecimento Serviço  removido!"; 
	}
	
	// Altera o Estabelecimento Serviço no banco, pelos dados do objeto Serviço!
	public String alterar(EstabelecimentoServico estabelecimentoServico){
		EstabelecimentoServicoDAO estabelecimentoServicoDao = new EstabelecimentoServicoDAO();
		estabelecimentoServicoDao.altera(estabelecimentoServico);
		return "Estabelecimento Serviço alterado!";
	}
}
