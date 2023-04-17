package autenticacao.RMI;

import java.rmi.RemoteException;

public class Administrador extends Usuario {

    public Administrador() {
        super();
    }

    public Administrador(String nome, String senha, boolean podeLer, boolean podeEscrever) {
        super(nome, senha, podeLer, podeEscrever);
    }

    boolean registraUsuario(Autenticacao auth, String nome, String senha, boolean podeLer, boolean podeEscrever, boolean ehAdmin) throws RemoteException {
        return auth.registraUsuario(nome, senha, podeLer, podeEscrever, ehAdmin);
    }

}
