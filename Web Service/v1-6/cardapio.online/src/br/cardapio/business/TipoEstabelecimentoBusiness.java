package br.cardapio.business;

import java.util.List;

import br.cardapio.bean.TipoEstabelecimento;
import br.cardapio.dao.TipoEstabelecimentoDAO;

public class TipoEstabelecimentoBusiness {

    // Adiciona novo TipoEstabelecimento
	public String adiciona(TipoEstabelecimento tipoEstabelecimento){
		TipoEstabelecimentoDAO tipoEstabelecimentoDao = new TipoEstabelecimentoDAO();
		tipoEstabelecimentoDao.adiciona(tipoEstabelecimento);
		return "Tipo Estabelecimento inserido!";
	}
	// Remove o TipoEstabelecimento no banco através do seu ID
	public String remove(long idTipoEstabelecimento) {
		TipoEstabelecimentoDAO tipoEstabelecimentoDao = new TipoEstabelecimentoDAO();
		tipoEstabelecimentoDao.remove(idTipoEstabelecimento);
	    return "Tipo Estabelecimento  removido!"; 
	}
	
	// Altera o TipoEstabelecimento no banco, pelos dados do objeto Serviço!
	public String alterar(TipoEstabelecimento tipoEstabelecimento){
		TipoEstabelecimentoDAO tipoEstabelecimentoDao = new TipoEstabelecimentoDAO();
		tipoEstabelecimentoDao.altera(tipoEstabelecimento);
		return "Tipo Estabelecimento alterado!";
	}
	
	//Retorna Todos os TipoEstabelecimento
	public List <TipoEstabelecimento> getListaTipoEstabelecimento(){
		TipoEstabelecimentoDAO tipoEstabelecimentoDao = new TipoEstabelecimentoDAO();
		return tipoEstabelecimentoDao.getLista();
	}
	
	//Retorna Todos os TipoEstabelecimento por ID do Estabelecimento
	public List <TipoEstabelecimento> getListaTipoEstabelecimentoPorIdEstabelecimento(long idEstabelecimento){
		TipoEstabelecimentoDAO tipoEstabelecimentoDao = new TipoEstabelecimentoDAO();
		return tipoEstabelecimentoDao.getListaTipoEstabelecimentoPorIdEstabelecimento(idEstabelecimento);
	}
}
