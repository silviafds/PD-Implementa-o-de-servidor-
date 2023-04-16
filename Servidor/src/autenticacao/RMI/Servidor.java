package autenticacao.RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Servidor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int op;

        try {
            System.setProperty("java.rmi.server.hostname","127.0.0.1");

            Autenticacao autenticacao = new AutenticacaoImpl();  //objeto criado

            Registry registry = LocateRegistry.createRegistry(1099); // rmi na porta 1099

            Naming.rebind("rmi://127.0.0.1:1099/AutenticacaoImpl", autenticacao);


            System.out.println("Servidor pronto!");

            do {
                System.out.println("\n------------- MENU -------------");
                System.out.println("1 - Listar objetos remotos");
                System.out.println("2 - Listar usuários registrados");
                System.out.println("3 - Listar objetos");
                System.out.println("4 - Encerrar servidor");
                System.out.println("--------------------------------");
                System.out.print("\nDigite sua opção: ");
                op = sc.nextInt();
                sc.nextLine();

                switch (op){
                    case 1:
                        String [] lista = registry.list();
                        for (String string : lista) {
                            System.out.println("Obj:" + string);
                        }
                        break;

                    case 2:
                        ((AutenticacaoImpl) autenticacao).listaUsuarios();
                        break;

                    case 3:
                        ((AutenticacaoImpl) autenticacao).listaObjetos();
                        break;

                    case 4: break;

                    default: System.out.println("Opção inválida!");
                }
            }while (op != 3);

        } catch (RemoteException | MalformedURLException e) {
            System.out.println("Sistema com ERRO!!!!");
        }

    }

}
