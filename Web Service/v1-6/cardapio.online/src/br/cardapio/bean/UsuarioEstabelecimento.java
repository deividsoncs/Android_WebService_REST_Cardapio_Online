package br.cardapio.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UsuarioEstabelecimento{
 
	private long id;
	
	private String nome;

	private String login;
	 
	private String senha;
	 
	public UsuarioEstabelecimento() {
		super();
	}


	public UsuarioEstabelecimento(String nome, String login,
			String senha) {
		super();
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}

	public UsuarioEstabelecimento(long id, String nome, String login,
			String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	@Override
	public String toString() {
		return "UsuarioEstabelecimento [id=" + id + ", nome=" + nome
				+ ", login=" + login + ", senha=" + senha + "]";
	}



	public void obterCardapio() {
	 
	}
	 
}
 
