package autenticacao.RMI;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {

    public static void main(String[] args) {

        try {
            Registry registry = LocateRegistry.createRegistry(1099); // rmi na porta 1099

            AutenticacaoImpl autenticacao = new AutenticacaoImpl();  //objeto criado

            Naming.bind("Autenticacao", autenticacao);
        } catch (RemoteException | AlreadyBoundException | MalformedURLException e) {
            System.out.println("Sistema com ERRO!!!!");
        }

    }

}
