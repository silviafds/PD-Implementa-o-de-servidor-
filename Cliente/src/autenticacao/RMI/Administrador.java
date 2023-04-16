package autenticacao.RMI;

import java.rmi.RemoteException;

public class Administrador extends Usuario {

	private int identificador;

	public Administrador() {
		super();
	}

	public Administrador(String nome, String senha, String autorizacao, int identificador) {
		super(nome, senha, autorizacao);
		this.identificador = identificador;
	}

	public int getIdAdm() {
		return identificador;
	}

	public void setIdAdm(int idAdm) {
		this.identificador = idAdm;
	}

	void registraUsuario(Autenticacao auth, String nome, String senha, String permissao) throws RemoteException {
		auth.registraUsuario(nome, senha, permissao);
	}
	
}
