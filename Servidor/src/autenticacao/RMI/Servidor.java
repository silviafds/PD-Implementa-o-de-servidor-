package autenticacao.RMI;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Servidor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.setProperty("java.rmi.server.hostname","127.0.0.1");

            Autenticacao autenticacao = new AutenticacaoImpl();  //objeto criado

            Registry registry = LocateRegistry.createRegistry(1099); // rmi na porta 1099

            Naming.rebind("rmi://127.0.0.1:1099/AutenticacaoImpl", autenticacao);


            System.out.println("Servidor pronto!");
            sc.nextInt();

            String [] lista = registry.list(); //lista de objetos remotos
            for (String string : lista) {
                System.out.println("Obj:" + string);
            }

            sc.nextInt();

        } catch (RemoteException | MalformedURLException e) {
            System.out.println("Sistema com ERRO!!!!");
        }

    }

}
