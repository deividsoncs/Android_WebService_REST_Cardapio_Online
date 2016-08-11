package br.cardapio.listas;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import br.cardapio.bean.SecaoCardapio;

@XmlRootElement(name = "lista_secao_cardapio")
@XmlAccessorType (XmlAccessType.FIELD)
public class SecaoCardapioList {
	
	@XmlElement( name = "secao_cardapio")
    private List <SecaoCardapio> lista =  null;

    public SecaoCardapioList(){
        lista = new ArrayList<SecaoCardapio>();
    }

    public void add(SecaoCardapio novo){
        lista.add(novo);
    }
    
    public boolean isEmpty(){
    	return lista.isEmpty();
    }
    
	public String toString() {
		String str = " ";
		for (SecaoCardapio objeto : lista){
			str += objeto.toString() + " \n";
		}
		return str;
	}

	public List<SecaoCardapio> getLista() {
		return lista;
	}

	public void setLista(List<SecaoCardapio> lista) {
		this.lista = lista;
	}
	
	
}
