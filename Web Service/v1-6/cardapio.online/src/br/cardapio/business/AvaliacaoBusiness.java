package br.cardapio.business;

import java.util.List;

import br.cardapio.bean.Avaliacao;
import br.cardapio.dao.AvaliacaoDAO;


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
		    return "Avaliação deletada!"; 
		}
		
		// Altera o Avaliacao no banco, pelos dados do objeto avaliacao!
		public String alterar(Avaliacao avaliacao){
			AvaliacaoDAO avaliacaoDao = new AvaliacaoDAO();
			avaliacaoDao.altera(avaliacao);
			return "Avaliacao alterada!";
		}
		
		// Busca todas Avaliações da tabela, pelo idEstabelecimento, retorna em formato de ArrayList.	
		public List <Avaliacao> getListaPorIdEstabelecimento(long idEstabelecimento) {
			AvaliacaoDAO avaliacaoDao = new AvaliacaoDAO();
			return avaliacaoDao.getListaPorIdEstabelecimento(idEstabelecimento);
		}
}
