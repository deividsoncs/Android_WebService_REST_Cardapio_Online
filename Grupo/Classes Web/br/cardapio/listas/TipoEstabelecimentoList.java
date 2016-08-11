package br.cardapio.listas;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import br.cardapio.bean.TipoEstabelecimento;

@XmlRootElement(name = "lista_servicos")
@XmlAccessorType (XmlAccessType.FIELD)
public class TipoEstabelecimentoList {
	
	@XmlElement( name = "servico")
    private List <TipoEstabelecimento> lista =  null;

    public TipoEstabelecimentoList(){
        lista = new ArrayList<TipoEstabelecimento>();
    }

    public void add(TipoEstabelecimento novo){
        lista.add(novo);
    }
    
    public boolean isEmpty(){
    	return lista.isEmpty();
    }
    
	public String toString() {
		String str = " ";
		for (TipoEstabelecimento objeto : lista){
			str += objeto.toString() + " \n";
		}
		return str;
	}

	public List<TipoEstabelecimento> getLista() {
		return lista;
	}

	public void setLista(List<TipoEstabelecimento> lista) {
		this.lista = lista;
	}
	
}
