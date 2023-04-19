package autenticacao.RMI;

import java.rmi.Naming;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int op;

        try {
            // Obter objeto de forma remota
            Autenticacao auth = (Autenticacao) Naming.lookup("rmi://127.0.0.1:1099/AutenticacaoImpl");

            do {
                System.out.println("\n------------- MENU -------------");
                System.out.println("1 - Registrar novo usuario");
                System.out.println("2 - Solicitar acesso a um objeto");
                System.out.println("3 - Sair");
                System.out.println("--------------------------------");
                System.out.print("\nDigite sua opcao: ");
                op = sc.nextInt();
                sc.nextLine();

                switch (op){
                    case 1:
                        System.out.print("\nDigite o seu nome: ");
                        String nomeCriador = sc.nextLine();
                        System.out.print("\nDigite a sua senha: ");
                        String senhaCriador = sc.nextLine();
                        if (auth.ehAdmin(nomeCriador, senhaCriador)) {
                            System.out.print("\nDigite o nome do usuario a ser registrado: ");
                            String nome = sc.nextLine();
                            System.out.print("\nDigite a senha do usuario a ser registrado: ");
                            String senha = sc.nextLine();
                            System.out.print("\nO novo usuario tera permissao de leitura? (s/n): ");
                            String podeLer = sc.nextLine();
                            System.out.print("\nO novo usuario tera permissao de escrita? (s/n): ");
                            String podeEscrever = sc.nextLine();
                            System.out.print("\nO novo usuario sera administrador? (s/n): ");
                            String ehAdmin = sc.nextLine();
                            if (auth.registraUsuario( nome, senha, podeLer.equals("s"), podeEscrever.equals("s"), ehAdmin.equals("s"))) {
                                System.out.println("\nUsuario registrado com sucesso!");
                            } else {
                                System.out.println("\nErro ao registrar usuario!");
                            }
                        } else {
                            System.out.println("\nVoce nao tem permissao para registrar usuarios!");
                        }
                        break;

                    case 2:
                        System.out.print("\nDigite o seu nome: ");
                        String nomeUsuario = sc.nextLine();
                        System.out.print("\nDigite a sua senha: ");
                        String senhaUsuario = sc.nextLine();
                        System.out.print("\nDigite o nome do objeto que deseja acessar: ");
                        String nomeObjeto = sc.nextLine();
                        System.out.print("\nDigite a operacao que deseja realizar (1 - Ler | 2 - Escrever): ");
                        String operacao = sc.nextLine();
                        if (operacao.equals("1")) {
                            System.out.println("\n" + auth.solicitaAcesso(nomeUsuario, senhaUsuario, nomeObjeto, "ler"));
                        } else if (operacao.equals("2")) {
                            System.out.println("\n" + auth.solicitaAcesso(nomeUsuario, senhaUsuario, nomeObjeto, "escrever"));
                        } else {
                            System.out.println("\nOperacao invalida!");
                            break;
                        }
                        break;

                    case 3: break;

                    default: System.out.println("\nOpcao invalida!");
                }
            }while (op != 3);

            System.out.println("\n\nFim do programa!");

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
