package autenticacao.RMI;

import java.rmi.RemoteException;

public interface Autenticacao {


    // método que cadastra novo usuário
    public void registraUsuario(String nome, String senha, String permissao) throws RemoteException;

    // método que autentica um usuário e o autoriza a operar um objeto
    boolean solicitaAcesso(String nome, String senha, String objeto, String operacao) throws RemoteException;

}
