package autenticacao.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Autenticacao extends Remote {

    // método que cadastra novo usuário
    boolean registraUsuario(String nome, String senha, String permissao) throws RemoteException;

    // método que autentica um usuário e o autoriza a operar um objeto
    String solicitaAcesso(String nome, String senha, String objeto, String operacao) throws RemoteException;
}
