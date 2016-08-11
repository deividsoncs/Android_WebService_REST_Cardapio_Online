package br.cardapio.business;

import java.util.List;

import br.cardapio.bean.ItemCardapio;
import br.cardapio.dao.ItemCardapioDAO;
import br.cardapio.listas.ItemCardapioList;

public class ItemCardapioBusiness {
    // Adiciona novo ItemCardapio
	public String adiciona(ItemCardapio itemCardapio){
		ItemCardapioDAO itemCardapioDao = new ItemCardapioDAO();
		itemCardapioDao.adiciona(itemCardapio);
		return "Item Cardapio inserido!";
	}
	// Remove o ItemCardapio no banco através do seu ID
	public String remove(long idItemCardapio) {
		ItemCardapioDAO itemCardapioDao = new ItemCardapioDAO();
		itemCardapioDao.remove(idItemCardapio);
	    return "Item Cardapio removido!"; 
	}
	
	// Altera o ItemCardapio no banco, pelos dados do objeto cardapio!
	public String alterar(ItemCardapio itemCardapio){
		ItemCardapioDAO itemCardapioDao = new ItemCardapioDAO();
		itemCardapioDao.altera(itemCardapio);
		return "Item Cardapio alterado!";
	}
	
	//Retorna o(s) ItemCardapio(s) referente ao ID da secao_cardapio passada
	public ItemCardapioList getItemListaPorIdSecaoIdCardapio(long idSecaoCardapio){
		ItemCardapioDAO itemCardapioDao = new ItemCardapioDAO();
		return itemCardapioDao.getListaItemsPorIdSecao(idSecaoCardapio);
	}
	
	//Retorna Todos os ItemCardapios em Promocao
	public List <ItemCardapio> getItemListaPorPromocao(){
		ItemCardapioDAO itemCardapioDao = new ItemCardapioDAO();
		return itemCardapioDao.getListaPorItemEmPromocao();
	}
	
	//Retorna Todos os ItemCardapios em Promocao
	public ItemCardapio getItemPorIdItem(long idItemCardapio){
		ItemCardapioDAO itemCardapioDao = new ItemCardapioDAO();
		return itemCardapioDao.getItemPorIdItem(idItemCardapio);
	}
}
