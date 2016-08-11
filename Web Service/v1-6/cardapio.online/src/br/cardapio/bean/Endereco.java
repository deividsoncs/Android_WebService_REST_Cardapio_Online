package br.cardapio.bean;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Endereco {
	//Temos conhecimento que esta modelagem não é a mais adequeda, porém, para fins de 
	//protótipo podemos propô-la?
	
	private long id;
	
	private long idEstabelecimento;
	
	private String cep;
	 
	private int numero;
	 
	private String complemento;
	 
	private String logradouro;
	 
	private String estado;
	 
	private String cidade;	
	
	private String bairro;

	public Endereco() {
		super();
	}

	public Endereco(long idEstabelecimento, String cep, int numero,
			String complemento, String logradouro, String estado,
			String cidade, String bairro) {
		super();
		this.idEstabelecimento = idEstabelecimento;
		this.cep = cep;
		this.numero = numero;
		this.complemento = complemento;
		this.logradouro = logradouro;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", idEstabelecimento="
				+ idEstabelecimento + ", cep=" + cep + ", numero=" + numero
				+ ", complemento=" + complemento + ", logradouro=" + logradouro
				+ ", estado=" + estado + ", cidade=" + cidade + ", bairro="
				+ bairro + "]";
	}
	
	
	 
}
 
