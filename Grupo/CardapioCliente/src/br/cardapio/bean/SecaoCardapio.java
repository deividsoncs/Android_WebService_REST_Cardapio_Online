package br.cardapio.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SecaoCardapio {
 
	private long id;
	
	private long idCardapio;
	
	private String nomeSecaoCardapio;

	public SecaoCardapio(long idCardapio, String nomeSecaoCardapio) {
		super();
		this.idCardapio = idCardapio;
		this.nomeSecaoCardapio = nomeSecaoCardapio;
	}
	
	public SecaoCardapio(long id, long idCardapio, String nomeSecaoCardapio) {
		super();
		this.id = id;
		this.idCardapio = idCardapio;
		this.nomeSecaoCardapio = nomeSecaoCardapio;
	}

	public SecaoCardapio() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdCardapio() {
		return idCardapio;
	}

	public void setIdCardapio(long idCardapio) {
		this.idCardapio = idCardapio;
	}

	public String getNomeSecaoCardapio() {
		return nomeSecaoCardapio;
	}

	public void setNomeSecaoCardapio(String nomeSecaoCardapio) {
		this.nomeSecaoCardapio = nomeSecaoCardapio;
	}

	@Override
	public String toString() {
		return "SecaoCardapio [id=" + id + ", idCardapio=" + idCardapio
				+ ", nomeSecaoCardapio=" + nomeSecaoCardapio + "]";
	}
	
	
	
	
	 
}
 
