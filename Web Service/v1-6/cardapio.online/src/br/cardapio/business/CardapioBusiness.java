package br.cardapio.business;

import br.cardapio.bean.Cardapio;
import br.cardapio.dao.CardapioDAO;

public class CardapioBusiness {
	        // Adiciona novo Cardapio
			public String adiciona(Cardapio cardapio){
				CardapioDAO cardapioDao = new CardapioDAO();
				cardapioDao.adiciona(cardapio);
				return "Cardapio inserido!";
			}
			// Remove o Cardapio no banco através do seu ID
			public String remove(long idCardapio) {
				CardapioDAO cardapioDao = new CardapioDAO();
				cardapioDao.remove(idCardapio);
			    return "Cardapio removido!"; 
			}
			
			// Altera o Cardapio no banco, pelos dados do objeto cardapio!
			public String alterar(Cardapio cardapio){
				CardapioDAO cardapioDao = new CardapioDAO();
				cardapioDao.altera(cardapio);
				return "Cardapio alterado!";
			}
			
			//Retorna o cardápio referente ao ID do estabelecimento passado
			public Cardapio getCardapioPorIdEstabelecimento(long idEstabelecimento){
				CardapioDAO cardapioDao = new CardapioDAO();
				return cardapioDao.getCardapio(idEstabelecimento);
			}
}
