package br.cardapio.business;

import java.util.List;

import br.cardapio.bean.Servicos;
import br.cardapio.dao.ServicosDAO;

public class ServicoBusiness {
    // Adiciona novo Servi�o
	public String adiciona(Servicos servicos){
		ServicosDAO servicosDao = new ServicosDAO();
		servicosDao.adiciona(servicos);
		return "Servi�o inserido!";
	}
	// Remove o Servi�o no banco atrav�s do seu ID
	public String remove(long idServico) {
		ServicosDAO servicosDao = new ServicosDAO();
		servicosDao.remove(idServico);
	    return "Servi�o  removido!"; 
	}
	
	// Altera o Servi�o no banco, pelos dados do objeto Servi�o!
	public String alterar(Servicos servicos){
		ServicosDAO servicosDao = new ServicosDAO();
		servicosDao.altera(servicos);
		return "Servi�o alterado!";
	}
	
	//Retorna Todos os Servi�os
	public List <Servicos> getListaServicos(){
		ServicosDAO servicosDao = new ServicosDAO();
		return servicosDao.getLista();
	}
	
	//Retorna Todos os Servi�o por ID do Estabelecimento
	public List <Servicos> getListaServicosPorIdEstabelecimento(long idEstabelecimento){
		ServicosDAO servicosDao = new ServicosDAO();
		return servicosDao.getListaServicosPorIdEstabelecimento(idEstabelecimento);
	}
	
}
