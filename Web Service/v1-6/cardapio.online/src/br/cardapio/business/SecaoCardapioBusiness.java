package br.cardapio.business;

import java.util.List;

import br.cardapio.bean.SecaoCardapio;
import br.cardapio.dao.SecaoCardapioDAO;

public class SecaoCardapioBusiness {
    // Adiciona novo SecaoCardapio
	public String adiciona(SecaoCardapio secaoCardapio){
		SecaoCardapioDAO secaoCardapioDao = new SecaoCardapioDAO();
		secaoCardapioDao.adiciona(secaoCardapio);
		return "Seção Cardapio inserido!";
	}
	// Remove o SecaoCardapio no banco através do seu ID
	public String remove(long idSecaoCardapio) {
		SecaoCardapioDAO secaoCardapioDao = new SecaoCardapioDAO();
		secaoCardapioDao.remove(idSecaoCardapio);
	    return "Seção Cardapio removido!"; 
	}
	
	// Altera o SecaoCardapio no banco, pelos dados do objeto secaoCardapio!
	public String alterar(SecaoCardapio secaoCardapio){
		SecaoCardapioDAO secaoCardapioDao = new SecaoCardapioDAO();
		secaoCardapioDao.altera(secaoCardapio);
		return "Seção Cardapio alterado!";
	}
	
	//Retorna Todos os SecaoCardapios por ID do cardapio
	public List <SecaoCardapio> getListaPorIdCardapio(long idCardapio){
		SecaoCardapioDAO secaoCardapioDao = new SecaoCardapioDAO();
		return secaoCardapioDao.getListaSecaoPorIdCardapio(idCardapio);
	}
}
