package br.cardapio.business;

import br.cardapio.bean.EstabelecimentoServico;
import br.cardapio.dao.EstabelecimentoServicoDAO;


public class EstabelecimentoServicoBusiness {
	
    // Adiciona novo Estabelecimento Serviço
	public String adiciona(EstabelecimentoServico estabelecimentoServico){
		EstabelecimentoServicoDAO estabelecimentoServicoDao = new EstabelecimentoServicoDAO();
		if (estabelecimentoServicoDao.jaExiste(estabelecimentoServico)==false){
			estabelecimentoServicoDao.adiciona(estabelecimentoServico);
			return "Servico inserido!";
		}else
			return "Servico já cadastrado!";
	}
	// Remove o Estabelecimento Serviço no banco através do seu ID
	public String remove(long idEstabelecimento, long idServico) {
		EstabelecimentoServicoDAO estabelecimentoServicoDao = new EstabelecimentoServicoDAO();
		estabelecimentoServicoDao.remove(idEstabelecimento, idServico);
	    return "Estabelecimento Serviço  removido!"; 
	}
	
	// Altera o Estabelecimento Serviço no banco, pelos dados do objeto Serviço!
	public String alterar(EstabelecimentoServico estabelecimentoServico){
		EstabelecimentoServicoDAO estabelecimentoServicoDao = new EstabelecimentoServicoDAO();
		estabelecimentoServicoDao.altera(estabelecimentoServico);
		return "Estabelecimento Serviço alterado!";
	}
}
