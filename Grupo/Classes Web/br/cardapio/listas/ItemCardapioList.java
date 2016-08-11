package br.cardapio.listas;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import br.cardapio.bean.ItemCardapio;

@XmlRootElement(name = "lista_item_cardapio")
@XmlAccessorType (XmlAccessType.FIELD)
public class ItemCardapioList {
	
	@XmlElement( name = "item_cardapio")
    private List <ItemCardapio> lista =  null;

    public ItemCardapioList(){
        lista = new ArrayList<ItemCardapio>();
    }

    public void add(ItemCardapio novo){
        lista.add(novo);
    }
    
    public boolean isEmpty(){
    	return lista.isEmpty();
    }
    
	public String toString() {
		String str = " ";
		for (ItemCardapio objeto : lista){
			str += objeto.toString() + " \n";
		}
		return str;
	}
	
    public List<ItemCardapio> getLista() {
        return lista;
    }

    public void setLista(List<ItemCardapio> lista) {
        this.lista = lista;
    }
}