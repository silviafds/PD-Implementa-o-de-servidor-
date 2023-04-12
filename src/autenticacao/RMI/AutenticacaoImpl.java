package autenticacao.RMI;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

public class AutenticacaoImpl implements Autenticacao {
	
	//guarda os pares-chave valor em uma tabela
	private Map<String, String> usuario = new HashMap<>();
	private Map<String, String> permissao = new HashMap<>();
	
	public AutenticacaoImpl() throws RemoteException { }

	@Override
	public void registrar(String nome, String senha, String permissao) throws RemoteException {
		this.usuario.put(nome, senha);
		this.permissao.put(nome, permissao);
	}

	@Override
	public boolean autenticacao(String nome, String senha) throws RemoteException {
		String senhaUsuario = this.usuario.get(nome);
		
		Boolean autentic = senhaUsuario != null && senhaUsuario.equals(senha) ? true : false;
		return autentic;
	}

	@Override
	public boolean autorizacao(String nome, String objeto, String permissao) throws RemoteException {
		String permissaoAutorizacao = this.permissao.get(nome);
		
		
		
		return false;
	}

}
