package autenticacao.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Autenticacao extends Remote {

    // m�todo que cadastra novo usu�rio
    boolean registraUsuario(String nome, String senha, String permissao) throws RemoteException;

    // m�todo que autentica um usu�rio e o autoriza a operar um objeto
    boolean solicitaAcesso(String nome, String senha, String objeto, String operacao) throws RemoteException;
}
