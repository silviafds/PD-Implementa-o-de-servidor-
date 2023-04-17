package autenticacao.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Autenticacao extends Remote {

    // Método que cadastra novo usuário
    boolean registraUsuario(String nome, String senha, boolean podeLer, boolean podeEscrever, boolean ehAdmin) throws RemoteException;

    // Método que autentica um usuário e o autoriza a operar um objeto
    String solicitaAcesso(String nome, String senha, String objeto, String operacao) throws RemoteException;

    // Método que verifica se um usuario é administrador
    boolean ehAdmin(String nome, String senha) throws RemoteException;
}
