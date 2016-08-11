package br.cardapio.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Estabelecimento {
	
	private long id;
	
	private long idUsuario;
 
	private String razaoSocial;
	 
	private String nomeFantasia;
	 
	private String telefone;
	 
	private String email;
	 
	private String foto;
	
	private int gostaram;

	
	
	public Estabelecimento() {
		super();
	}

	public Estabelecimento(long idUsuario, String razaoSocial,
			String nomeFantasia, String telefone, String email, String foto,
			int gostaram) {
		super();
		this.idUsuario = idUsuario;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.telefone = telefone;
		this.email = email;
		this.foto = foto;
		this.gostaram = gostaram;
	}
	

	public Estabelecimento(long idUsuario, String razaoSocial,
			String nomeFantasia, String telefone, String email, String foto) {
		super();
		this.idUsuario = idUsuario;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.telefone = telefone;
		this.email = email;
		this.foto = foto;
	}
	
	public Estabelecimento(long id, long idUsuario, String razaoSocial,
			String nomeFantasia, String telefone, String email, String foto,
			int gostaram) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.telefone = telefone;
		this.email = email;
		this.foto = foto;
		this.gostaram = gostaram;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFoto() {
		return foto;
	}
	

	public void setFoto(String foto) {
		this.foto = foto;
	}
	

	public int getGostaram() {
		return gostaram;
	}

	public void setGostaram(int gostaram) {
		this.gostaram = gostaram;
	}

	@Override
	public String toString() {
		return "Estabelecimento [id=" + id + ", idUsuario=" + idUsuario
				+ ", razaoSocial=" + razaoSocial + ", nomeFantasia="
				+ nomeFantasia + ", telefone=" + telefone + ", email=" + email
				+ ", foto=" + foto + ", gostaram=" + gostaram + "]";
	}


	
}
 
