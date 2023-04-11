package autenticacao.RMI;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

public class AutenticacaoImpl implements Autenticacao {
	
	//guarda os pares-chave valor em uma tabela
	private Map<String, String> nome = new HashMap<>();
	private Map<String, String> permissao = new HashMap<>();
	
	public AutenticacaoImpl() throws RemoteException { }

	@Override
	public void registrar(String nome, String senha, String permissao) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean autenticacao(String nome, String senha) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean autorizacao(String nome, String objectName, String permissao) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
