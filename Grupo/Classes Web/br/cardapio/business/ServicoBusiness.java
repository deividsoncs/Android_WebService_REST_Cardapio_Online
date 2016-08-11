package br.cardapio.business;

import br.cardapio.bean.Servicos;
import br.cardapio.dao.ServicosDAO;
import br.cardapio.listas.ServicosList;

public class ServicoBusiness {
    // Adiciona novo Serviço
	public String adiciona(Servicos servicos){
		ServicosDAO servicosDao = new ServicosDAO();
		servicosDao.adiciona(servicos);
		return "Serviço inserido!";
	}
	// Remove o Serviço no banco através do seu ID
	public String remove(long idServico) {
		ServicosDAO servicosDao = new ServicosDAO();
		servicosDao.remove(idServico);
	    return "Serviço  removido!"; 
	}
	
	// Altera o Serviço no banco, pelos dados do objeto Serviço!
	public String alterar(Servicos servicos){
		ServicosDAO servicosDao = new ServicosDAO();
		servicosDao.altera(servicos);
		return "Serviço alterado!";
	}
	
	//Retorna Todos os Serviços
	public ServicosList getListaServicos(){
		ServicosDAO servicosDao = new ServicosDAO();
		return servicosDao.getLista();
	}
	
	//Retorna Todos os Serviço por ID do Estabelecimento
	public ServicosList getListaServicosPorIdEstabelecimento(long idEstabelecimento){
		ServicosDAO servicosDao = new ServicosDAO();
		return servicosDao.getListaServicosPorIdEstabelecimento(idEstabelecimento);
	}
	
}
