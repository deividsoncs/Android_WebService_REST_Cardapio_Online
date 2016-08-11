package br.cardapio.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Avaliacao {
	
	private long id;
	private long idEstabelecimento;
	private String Relato;
	private byte positivo;
	
	public Avaliacao() {
		super();
	}
	
	public Avaliacao(long idEstabelecimento, String relato, byte positivo) {
		super();
		this.idEstabelecimento = idEstabelecimento;
		Relato = relato;
		this.positivo = positivo;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdEstabelecimento() {
		return idEstabelecimento;
	}
	public void setIdEstabelecimento(long idEstabelecimento) {
		this.idEstabelecimento = idEstabelecimento;
	}
	public String getRelato() {
		return Relato;
	}
	public void setRelato(String relato) {
		Relato = relato;
	}
	public byte getPositivo() {
		return positivo;
	}
	public void setPositivo(byte positivo) {
		this.positivo = positivo;
	}

	@Override
	public String toString() {
		return "Avaliacao [id=" + id + ", idEstabelecimento="
				+ idEstabelecimento + ", Relato=" + Relato + ", positivo="
				+ positivo + "]";
	}
}
