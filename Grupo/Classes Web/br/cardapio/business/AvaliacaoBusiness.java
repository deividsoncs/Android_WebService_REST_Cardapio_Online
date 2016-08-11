package br.cardapio.business;

import br.cardapio.bean.Avaliacao;
import br.cardapio.dao.AvaliacaoDAO;
import br.cardapio.listas.AvaliacaoList;


public class AvaliacaoBusiness {
	
	    // Adiciona novo Avaliacao
		public String adiciona(Avaliacao avaliacao){
			AvaliacaoDAO avaliacaoDao = new AvaliacaoDAO();
			avaliacaoDao.adiciona(avaliacao);
			return "Avaliacao inserida!";
		}
		// Remove o Avaliacao no banco através do seu ID
		public String remove(long idAvaliacao) {
			AvaliacaoDAO avaliacaoDao = new AvaliacaoDAO();
			avaliacaoDao.remove(idAvaliacao);
		    return "Avaliacao deletada!"; 
		}
		
		// Altera o Avaliacao no banco, pelos dados do objeto avaliacao!
		public String alterar(Avaliacao avaliacao){
			AvaliacaoDAO avaliacaoDao = new AvaliacaoDAO();
			avaliacaoDao.altera(avaliacao);
			return "Avaliacao alterada!";
		}
		
		// Busca todas Avaliações da tabela, pelo idEstabelecimento, retorna em formato de ArrayList.	
		public AvaliacaoList getListaPorIdEstabelecimento(long idEstabelecimento) {
			AvaliacaoDAO avaliacaoDao = new AvaliacaoDAO();
			return avaliacaoDao.getListaPorIdEstabelecimento(idEstabelecimento);
		}
}
