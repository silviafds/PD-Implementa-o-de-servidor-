package autenticacao.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Autenticacao extends Remote {

    // M�todo que cadastra novo usu�rio
    boolean registraUsuario(String nome, String senha, boolean podeLer, boolean podeEscrever, boolean ehAdmin) throws RemoteException;

    // M�todo que autentica um usu�rio e o autoriza a operar um objeto
    String solicitaAcesso(String nome, String senha, String objeto, String operacao) throws RemoteException;

    // M�todo que verifica se um usuario � administrador
    boolean ehAdmin(String nome, String senha) throws RemoteException;
}
