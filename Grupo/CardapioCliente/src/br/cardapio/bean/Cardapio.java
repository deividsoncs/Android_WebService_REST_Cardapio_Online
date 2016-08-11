package br.cardapio.bean;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Cardapio {
 
	private long id;
	
	private long idEstabelecimento;
	
	private Date dataModificacao;


	public Cardapio(long idEstabelecimento, Date dataModificacao) {
		super();
		this.idEstabelecimento = idEstabelecimento;
		this.dataModificacao = dataModificacao;
	}
	
	public Cardapio(long id, long idEstabelecimento, Date dataModificacao) {
		super();
		this.id = id;
		this.idEstabelecimento = idEstabelecimento;
		this.dataModificacao = dataModificacao;
	}

	public Cardapio() {
		super();
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

	public Date getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(Date dataModificacao) {
		this.dataModificacao = dataModificacao;
	}

	@Override
	public String toString() {
		return "Cardapio [id=" + id + ", idEstabelecimento="
				+ idEstabelecimento + ", dataModificacao=" + dataModificacao
				+ "]";
	}	 
}
 
