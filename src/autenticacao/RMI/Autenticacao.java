package autenticacao.RMI;

import java.rmi.RemoteException;

public interface Autenticacao {
	

	 // método que cadastra novo usuário
    public void registrar(String nome, String senha, String permissao) throws RemoteException;

    // método no qual autentica um usuário
    public boolean autenticacao(String nome, String senha) throws RemoteException;

    // método para verificar a possibilidade de um usuário possur permissão para acessar um objeto
    public boolean autorizacao(String nome, String objectName, String permissao) throws RemoteException;
    
}
