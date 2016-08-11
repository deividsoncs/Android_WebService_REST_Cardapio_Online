package br.cardapio.business;

import br.cardapio.bean.Endereco;
import br.cardapio.dao.EnderecoDAO;

public class EnderecoBusiness {
    // Adiciona novo Endere�o
	public String adiciona(Endereco endereco){
		EnderecoDAO enderecoDao = new EnderecoDAO();
		enderecoDao.adiciona(endereco);
		return "Endereco Inserido!";
	
	}
	// Remove o Endere�o no banco atrav�s do seu ID
	public String remove(long idEndereco) {
		EnderecoDAO enderecoDao = new EnderecoDAO();
		enderecoDao.remove(idEndereco);
	    return "Endereco removido!"; 
	}
	
	// Altera o Endere�o no banco, pelos dados do objeto cardapio!
	public String alterar(Endereco endereco){
		EnderecoDAO enderecoDao = new EnderecoDAO();
		enderecoDao.altera(endereco);
		return "Endereco alterado!";
	}
	
	//Retorna o Endere�o referente ao ID do estabelecimento passado
	public Endereco getEnderecoPorIdEstabelecimento(long idEstabelecimento){
		EnderecoDAO enderecoDao = new EnderecoDAO();
		return enderecoDao.getEnderecoPorIdEstabelecimento(idEstabelecimento);

	}
}