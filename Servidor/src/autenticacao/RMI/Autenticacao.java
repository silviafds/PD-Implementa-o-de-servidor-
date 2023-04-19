package autenticacao.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Autenticacao extends Remote {

    // Metodo que cadastra novo usuario
    boolean registraUsuario(String nome, String senha, boolean podeLer, boolean podeEscrever, boolean ehAdmin) throws RemoteException;

    // Metodo que autentica um usuario e o autoriza a operar um objeto
    String solicitaAcesso(String nome, String senha, String objeto, String operacao) throws RemoteException;

    // Metodo que verifica se um usuario eh administrador
    boolean ehAdmin(String nome, String senha) throws RemoteException;

}
