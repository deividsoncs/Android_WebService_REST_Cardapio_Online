package br.cardapio.business;

import br.cardapio.bean.Endereco;
import br.cardapio.dao.EnderecoDAO;

public class EnderecoBusiness {
    // Adiciona novo Endereço
	public String adiciona(Endereco endereco){
		EnderecoDAO enderecoDao = new EnderecoDAO();
		enderecoDao.adiciona(endereco);
		return "Endereço inserido!";
	}
	// Remove o Endereço no banco através do seu ID
	public String remove(long idEndereco) {
		EnderecoDAO enderecoDao = new EnderecoDAO();
		enderecoDao.remove(idEndereco);
	    return "Endereço removido!"; 
	}
	
	// Altera o Endereço no banco, pelos dados do objeto cardapio!
	public String alterar(Endereco endereco){
		EnderecoDAO enderecoDao = new EnderecoDAO();
		enderecoDao.altera(endereco);
		return "Endereço alterado!";
	}
	
	//Retorna o Endereço referente ao ID do estabelecimento passado
	public Endereco getEnderecoPorIdEstabelecimento(long idEstabelecimento){
		EnderecoDAO enderecoDao = new EnderecoDAO();
		return enderecoDao.getEnderecoPorIdEstabelecimento(idEstabelecimento);

	}
}