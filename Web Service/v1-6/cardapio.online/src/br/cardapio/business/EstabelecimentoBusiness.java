package br.cardapio.business;

import java.util.List;

import br.cardapio.bean.Estabelecimento;
import br.cardapio.dao.EstabelecimentoDAO;

public class EstabelecimentoBusiness {
	
	// Adiciona novo Estabelecimento
	public String adiciona(Estabelecimento estabelecimento){
		EstabelecimentoDAO estabelecimentoDao = new EstabelecimentoDAO();
		estabelecimentoDao.adiciona(estabelecimento);
		return "Estabelecimento inserido!";
	}
	// Remove o Estabelecimento no banco atrav�s do seu ID
	public String remove(long idEstabelecimento) {
		EstabelecimentoDAO estabelecimentoDao = new EstabelecimentoDAO();
	    estabelecimentoDao.remove(idEstabelecimento);
	    return "Estabelecimento deletado!"; 
	}
	
	// Altera o Estabelecimento no banco, pelos dados do objeto estabelecimento!
	public String alterar(Estabelecimento estabelecimento){
		EstabelecimentoDAO estabelecimentoDao = new EstabelecimentoDAO();
		estabelecimentoDao.altera(estabelecimento);
		return "Estabelecimento Alterado!";
	}
	
	// Busca todos Estabelecimento da tabelela usuario_estabelecimento, retorna em formato de ArrayList
	public List <Estabelecimento> getListaTodos(){
		  EstabelecimentoDAO estabelecimentoDao = new EstabelecimentoDAO();
		  return estabelecimentoDao.getLista();  
	  }
	
	// Busca o Estabelecimento pelo ID
	public Estabelecimento getPorId(long id){
		  EstabelecimentoDAO estabelecimentoDao = new EstabelecimentoDAO();
		  return estabelecimentoDao.getEstabelecimentoPorId(id);
	  }
	
	// Retornar a lista dos Estabelecimentos que tem algum ITEM de seu card�pio em PROMO��O
	public List <Estabelecimento> getListaPorPromocao(){
		EstabelecimentoDAO estabelecimentoDao = new EstabelecimentoDAO();
		return estabelecimentoDao.getListaPorPromocao();
	}
	
	// Retornar a lista dos Estabelecimentos passando o Nome do Estabelecimento
	public List <Estabelecimento> getListaPorNome(String nomeEstabelecimento){
		EstabelecimentoDAO estabelecimentoDao = new EstabelecimentoDAO();
		return estabelecimentoDao.getListaPorNome(nomeEstabelecimento);
	}
	
	// Retornar a lista dos Estabelecimentos passando a a Cidade
	public List <Estabelecimento> getListaPorCidades(String cidade) {
		EstabelecimentoDAO estabelecimentoDao = new EstabelecimentoDAO();
		return estabelecimentoDao.getListaPorCidades(cidade);
	}
	
	// Retornar a lista dos Estabelecimentos passando a ID do Servi�os selecionado, ex.: Todos estabelecimento que possuem "m�sica ao vivo"
	public List <Estabelecimento> getListaPorServicos(long id) {
		EstabelecimentoDAO estabelecimentoDao = new EstabelecimentoDAO();
		return estabelecimentoDao.getListaPorServicos(id);
	}
	
	// Lista todos Estabelecimentos pelos id do TipoEstabelecimento passado! Ex.: Lista de Estabelecimentos que s�o churrascarias.
	public List <Estabelecimento> getListaPorTipoEstabelecimento(long id) {
		EstabelecimentoDAO estabelecimentoDao = new EstabelecimentoDAO();
		return estabelecimentoDao.getListaPorTipoEstabelecimento(id);
	}
	
}
