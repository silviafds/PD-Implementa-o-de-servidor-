package autenticacao.RMI;

import autenticacao.RMI.Autenticacao;

import java.rmi.Naming;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int op;

        try {
            //obter objeto de forma remota
            Autenticacao auth = (Autenticacao) Naming.lookup("rmi://127.0.0.1:1099/AutenticacaoImpl");

            Administrador admin = new Administrador();
            Usuario user = new Usuario();

            final String nomeAdmin = "admin";
            final String senhaAdmin = "admin";

            do {
                System.out.println("\n------------- MENU -------------");
                System.out.println("1 - Registrar novo usu�rio");
                System.out.println("2 - Solicitar acesso a um objeto");
                System.out.println("3 - Sair");
                System.out.println("--------------------------------");
                System.out.print("\nDigite sua op��o: ");
                op = sc.nextInt();
                sc.nextLine();

                switch (op){
                    case 1:
                        System.out.print("Digite o seu nome: ");
                        String nomeCriador = sc.nextLine();
                        System.out.print("Digite a sua senha: ");
                        String senhaCriador = sc.nextLine();
                        if (nomeCriador.equals(nomeAdmin) && senhaCriador.equals(senhaAdmin)) {
                            System.out.print("Digite o nome do usu�rio a ser registrado: ");
                            String nome = sc.nextLine();
                            System.out.print("Digite a senha do usu�rio a ser registrado: ");
                            String senha = sc.nextLine();
                            System.out.print("Digite as permiss�es que o usu�rio registrado ter�: ");
                            String permissao = sc.nextLine();
                            if (auth.registraUsuario(nome, senha, permissao)) {
                                System.out.println("\nUsu�rio registrado com sucesso!");
                            } else {
                                System.out.println("\nErro ao registrar usu�rio!");
                            }
                        } else {
                            System.out.println("\nVoc� n�o tem permiss�o para registrar usu�rios!");
                        }
                        break;

                    case 2:
                        System.out.println("Digite o seu nome: ");
                        String nomeUsuario = sc.nextLine();
                        System.out.println("Digite a sua senha: ");
                        String senhaUsuario = sc.nextLine();
                        System.out.println("Digite o nome do objeto que deseja acessar: ");
                        String nomeObjeto = sc.nextLine();
                        System.out.println("Digite a opera��o que deseja realizar (\"ler\" ou \"escrever\"): ");
                        String operacao = sc.nextLine();
                        if (user.solicitaAcesso(auth, nomeUsuario, senhaUsuario, nomeObjeto, operacao)) {
                            System.out.println("Acesso concedido!");
                        } else {
                            System.out.println("Acesso negado!");
                        }
                        break;

                    case 3: break;

                    default: System.out.println("Op��o inv�lida!");
                }
            }while (op != 3);

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
