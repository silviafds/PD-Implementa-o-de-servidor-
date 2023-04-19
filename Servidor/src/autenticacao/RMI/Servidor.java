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
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");

            Autenticacao autenticacao = new AutenticacaoImpl();  //objeto criado

            Registry registry = LocateRegistry.createRegistry(1099); // rmi na porta 1099

            Naming.rebind("rmi://127.0.0.1:1099/AutenticacaoImpl", autenticacao);

            // Cria usuario administrador
            autenticacao.registraUsuario("admin", "admin", true, true, true);

            System.out.println("Servidor pronto!");

            do {
                System.out.println("\n------------- MENU -------------");
                System.out.println("1 - Listar objetos remotos");
                System.out.println("2 - Listar usuarios registrados");
                System.out.println("3 - Listar objetos");
                System.out.println("4 - Resetar usuarios e objetos");
                System.out.println("5 - Encerrar servidor");
                System.out.println("--------------------------------");
                System.out.print("\nDigite sua opcao: ");
                op = sc.nextInt();
                sc.nextLine();

                switch (op) {
                    case 1:
                        String[] lista = registry.list();
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

                    case 4:
                        ((AutenticacaoImpl) autenticacao).reset();
                        break;

                    case 5:
                        break;

                    default:
                        System.out.println("Opcao invalida!");
                }
            } while (op != 5);

            System.out.println("\n\nServidor encerrado!");

        } catch (RemoteException | MalformedURLException e) {
            System.out.println("Sistema com ERRO!!!!");
            e.printStackTrace();
        }
    }
}
