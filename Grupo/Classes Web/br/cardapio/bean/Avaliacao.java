package br.cardapio.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Avaliacao {
	
	private long id;
	private long idEstabelecimento;
	private String Relato;
	private int positivo;
	
	public Avaliacao() {
		super();
	}

	public Avaliacao(long id, long idEstabelecimento, String relato,
			int positivo) {
		super();
		this.id = id;
		this.idEstabelecimento = idEstabelecimento;
		Relato = relato;
		this.positivo = positivo;
	}

	public Avaliacao(long idEstabelecimento, String relato, int positivo) {
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

	public int getPositivo() {
		return positivo;
	}

	public void setPositivo(int positivo) {
		this.positivo = positivo;
	}

	@Override
	public String toString() {
		return "Avaliacao [id=" + id + ", idEstabelecimento="
				+ idEstabelecimento + ", Relato=" + Relato + ", positivo="
				+ positivo + "]";
	}
	
	
	

}
