package br.cardapio.bean;

import java.util.Date;


import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class ItemCardapio {
 
	//@XmlElement(name="id")
	private long id;
	
	//@XmlElement(name="id_secao_cardapio")
	private long idSecaoCardapio;
	
	//@XmlElement(name="nome_item")
	private String nomeItem;
	 
	//@XmlElement(name="preco")
	private Double preco;
	 
	//@XmlElement(name="descricao")
	private String descricao;
	
	//@XmlElement(name="foto")
	private String foto;
	
	//@XmlElement(name="percentual_desconto")
	private Double percentualDesconto;
	 
	//@XmlElement(name="data")
	private Date dataModificacao;
	

	public ItemCardapio() {
		super();
	}

	public ItemCardapio(int idSecaoCardapio, String nomeItem, Double preco,
			String descricao, String foto, Double percentualDesconto,
			Date dataModificacao) {
		super();
		this.idSecaoCardapio = idSecaoCardapio;
		this.nomeItem = nomeItem;
		this.preco = preco;
		this.descricao = descricao;
		this.foto = foto;
		this.percentualDesconto = percentualDesconto;
		this.dataModificacao = dataModificacao;
	}
	
	
	public ItemCardapio(long id, long idSecaoCardapio, String nomeItem,
			Double preco, String descricao, String foto,
			Double percentualDesconto, Date dataModificacao) {
		super();
		this.id = id;
		this.idSecaoCardapio = idSecaoCardapio;
		this.nomeItem = nomeItem;
		this.preco = preco;
		this.descricao = descricao;
		this.foto = foto;
		this.percentualDesconto = percentualDesconto;
		this.dataModificacao = dataModificacao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdSecaoCardapio() {
		return idSecaoCardapio;
	}

	public void setIdSecaoCardapio(long idSecaoCardapio) {
		this.idSecaoCardapio = idSecaoCardapio;
	}

	public String getNomeItem() {
		return nomeItem;
	}

	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Double getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(Double percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public Date getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(Date dataModificacao) {
		this.dataModificacao = dataModificacao;
	}

	@Override
	public String toString() {
		return "ItemCardapio [id=" + id + ", idSecaoCardapio="
				+ idSecaoCardapio + ", nomeItem=" + nomeItem + ", preco="
				+ preco + ", descricao=" + descricao + ", foto=" + foto
				+ ", percentualDesconto=" + percentualDesconto
				+ ", dataModificacao=" + dataModificacao + "]";
	} 
	
	
	
	
}
 
