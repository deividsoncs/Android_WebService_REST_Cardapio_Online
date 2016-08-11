package br.cardapio.bean;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Servicos {
 
	private long id;
	private String descricao;

	public Servicos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Servicos(String descricao) {
		super();
		this.descricao = descricao;
	}

	public Servicos(long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Servicos [id=" + id + ", descricao=" + descricao + "]";
	}
	
	
	 
}
 
