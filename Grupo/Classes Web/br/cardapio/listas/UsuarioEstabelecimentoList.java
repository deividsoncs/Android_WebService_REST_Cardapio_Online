package br.cardapio.listas;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import br.cardapio.bean.UsuarioEstabelecimento;

@XmlRootElement(name = "lista_usuarios")
@XmlAccessorType (XmlAccessType.FIELD)
public class UsuarioEstabelecimentoList {
	
	@XmlElement( name = "usuario")
    private List <UsuarioEstabelecimento> lista =  null;

    public UsuarioEstabelecimentoList(){
        lista = new ArrayList<UsuarioEstabelecimento>();
    }

    public void add(UsuarioEstabelecimento novo){
        lista.add(novo);
    }
    
    public boolean isEmpty(){
    	return lista.isEmpty();
    }
}