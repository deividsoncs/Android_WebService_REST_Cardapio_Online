package br.cardapio.listas;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import br.cardapio.bean.Avaliacao;

@XmlRootElement(name = "lista_avaliacao")
@XmlAccessorType (XmlAccessType.FIELD)
public class AvaliacaoList {
	
	@XmlElement( name = "avaliacao")
    private List <Avaliacao> lista =  null;

    public AvaliacaoList(){
        lista = new ArrayList<Avaliacao>();
    }

    public void add(Avaliacao novo){
        lista.add(novo);
    }
    
    public boolean isEmpty(){
    	return lista.isEmpty();
    }
    
	public String toString() {
		String str = " ";
		for (Avaliacao objeto : lista){
			str += objeto.toString() + " \n";
		}
		return str;
	}
}

