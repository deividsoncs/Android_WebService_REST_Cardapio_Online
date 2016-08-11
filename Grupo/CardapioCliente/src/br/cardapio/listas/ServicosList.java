package br.cardapio.listas;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import br.cardapio.bean.Servicos;

@XmlRootElement(name = "lista_servicos")
@XmlAccessorType (XmlAccessType.FIELD)
public class ServicosList {
	
	@XmlElement( name = "servico")
    private List <Servicos> lista =  null;

    public ServicosList(){
        lista = new ArrayList<Servicos>();
    }

    public void add(Servicos novo){
        lista.add(novo);
    }
    
    public boolean isEmpty(){
    	return lista.isEmpty();
    }
    
	public String toString() {
		String str = " ";
		for (Servicos objeto : lista){
			str += objeto.toString() + " \n";
		}
		return str;
	}

    public List<Servicos> getLista() {
        return lista;
    }

    public void setLista(List<Servicos> lista) {
        this.lista = lista;
    }
        
        
}
