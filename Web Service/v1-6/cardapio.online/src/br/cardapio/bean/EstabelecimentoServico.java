package br.cardapio.bean;

public class EstabelecimentoServico {

	private long id;
	private long idEstabelecimento;
	private long idServico;
	
	public EstabelecimentoServico(){
		super();
	}

	public EstabelecimentoServico(long id, long idEstabelecimento, long idServico) {
		super();
		this.id = id;
		this.idEstabelecimento = idEstabelecimento;
		this.idServico = idServico;
	}
	
	public EstabelecimentoServico(long idEstabelecimento, long idServico) {
		super();
		this.idEstabelecimento = idEstabelecimento;
		this.idServico = idServico;
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

	public long getIdServico() {
		return idServico;
	}

	public void setIdServico(long idServico) {
		this.idServico = idServico;
	}

	@Override
	public String toString() {
		return "EstabelecimentoServico [id=" + id + ", idEstabelecimento="
				+ idEstabelecimento + ", idServico=" + idServico + "]";
	}	
}
