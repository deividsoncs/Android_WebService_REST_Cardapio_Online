package br.cardapio.bean;

public class EstabelecimentoTipoEstabelecimento {

	private long id;
	private long idEstabelecimento;
	private long idTipoEstabelecimento;
	
	public EstabelecimentoTipoEstabelecimento() {
		super();
	}

	public EstabelecimentoTipoEstabelecimento(long id, long idEstabelecimento,
			long idTipoEstabelecimento) {
		super();
		this.id = id;
		this.idEstabelecimento = idEstabelecimento;
		this.idTipoEstabelecimento = idTipoEstabelecimento;
	}

	public EstabelecimentoTipoEstabelecimento(long idEstabelecimento,
			long idTipoEstabelecimento) {
		super();
		this.idEstabelecimento = idEstabelecimento;
		this.idTipoEstabelecimento = idTipoEstabelecimento;
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

	public long getIdTipoEstabelecimento() {
		return idTipoEstabelecimento;
	}

	public void setIdTipoEstabelecimento(long idTipoEstabelecimento) {
		this.idTipoEstabelecimento = idTipoEstabelecimento;
	}

	@Override
	public String toString() {
		return "EstabelecimentoTipoEstabelecimento [id=" + id
				+ ", idEstabelecimento=" + idEstabelecimento
				+ ", idTipoEstabelecimento=" + idTipoEstabelecimento + "]";
	}	
}
