package autenticacao.RMI;

import java.rmi.RemoteException;

public class Usuario {
	
	private String nome;
	private String senha;
	private String autorizacao;

	public  Usuario () {
	}

	public Usuario(String nome, String senha, String autorizacao) {
		super();
		this.nome = nome;
		this.senha = senha;
		this.autorizacao = autorizacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getAutorizacao() {
		return autorizacao;
	}

	public void setAutorizacao(String autorizacao) {
		this.autorizacao = autorizacao;
	}

	public boolean solicitaAcesso(Autenticacao auth, String nome, String senha, String objeto, String operacao) throws RemoteException {
		return auth.solicitaAcesso(nome, senha, objeto, operacao);
	}

}
