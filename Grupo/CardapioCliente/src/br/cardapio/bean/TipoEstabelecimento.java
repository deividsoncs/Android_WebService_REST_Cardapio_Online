package br.cardapio.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TipoEstabelecimento {

	private long id;
	private String tipoEstabelecimento;
	
	public TipoEstabelecimento() {
		super();
	}

	public TipoEstabelecimento(long id, String tipoEstabelecimento) {
		super();
		this.id = id;
		this.tipoEstabelecimento = tipoEstabelecimento;
	}

	
	public TipoEstabelecimento(String tipoEstabelecimento) {
		super();
		this.tipoEstabelecimento = tipoEstabelecimento;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipoEstabelecimento() {
		return tipoEstabelecimento;
	}

	public void setTipoEstabelecimento(String tipoEstabelecimento) {
		this.tipoEstabelecimento = tipoEstabelecimento;
	}

	@Override
	public String toString() {
		return "TipoEstabelecimento [id=" + id + ", tipoEstabelecimento="
				+ tipoEstabelecimento + "]";
	}	
}
