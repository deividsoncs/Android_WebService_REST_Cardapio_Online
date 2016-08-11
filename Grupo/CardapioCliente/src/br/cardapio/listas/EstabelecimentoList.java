package br.cardapio.listas;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import br.cardapio.bean.Estabelecimento;

@XmlRootElement(name = "lista_estabelecimento")
@XmlAccessorType (XmlAccessType.FIELD)
public class EstabelecimentoList {
	
	@XmlElement( name = "estabelecimento")
    private List <Estabelecimento> lista =  null;

    public EstabelecimentoList(){
        lista = new ArrayList<Estabelecimento>();
    }

    public EstabelecimentoList(List<Estabelecimento> lista) {
		super();
		this.lista = lista;
	}
    

	public List<Estabelecimento> getLista() {
		return lista;
	}

	public void setLista(List<Estabelecimento> lista) {
		this.lista = lista;
	}

	public void add(Estabelecimento novo){
        lista.add(novo);
    }
    
    public boolean isEmpty(){
    	return lista.isEmpty();
    }
    
	public String toString() {
		String str = " ";
		for (Estabelecimento objeto : lista){
			str += objeto.toString() + " \n";
		}
		return str;
	}
}

