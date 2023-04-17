package autenticacao.RMI;

import java.rmi.Naming;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int op;

        try {
            // Obter objeto de forma remota
            Autenticacao auth = (Autenticacao) Naming.lookup("rmi://127.0.0.1:1099/AutenticacaoImpl");

            Administrador admin = new Administrador();
            Usuario user = new Usuario();

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
                        if (auth.ehAdmin(nomeCriador, senhaCriador)) {
                            System.out.print("Digite o nome do usu�rio a ser registrado: ");
                            String nome = sc.nextLine();
                            System.out.print("Digite a senha do usu�rio a ser registrado: ");
                            String senha = sc.nextLine();
                            System.out.print("O novo usu�rio ter� permiss�o de leitura? (s/n): ");
                            String podeLer = sc.nextLine();
                            System.out.print("O novo usu�rio ter� permiss�o de escrita? (s/n): ");
                            String podeEscrever = sc.nextLine();
                            System.out.print("O novo usu�rio ser� administrador? (s/n): ");
                            String ehAdmin = sc.nextLine();
                            if (admin.registraUsuario(auth, nome, senha, podeLer.equals("s"), podeEscrever.equals("s"), ehAdmin.equals("s"))) {
                                System.out.println("\nUsu�rio registrado com sucesso!");
                            } else {
                                System.out.println("\nErro ao registrar usu�rio!");
                            }
                        } else {
                            System.out.println("\nVoc� n�o tem permiss�o para registrar usu�rios!");
                        }
                        break;

                    case 2:
                        System.out.print("Digite o seu nome: ");
                        String nomeUsuario = sc.nextLine();
                        System.out.print("Digite a sua senha: ");
                        String senhaUsuario = sc.nextLine();
                        System.out.print("Digite o nome do objeto que deseja acessar: ");
                        String nomeObjeto = sc.nextLine();
                        System.out.print("Digite a opera��o que deseja realizar (1 - Ler | 2 - Escrever): ");
                        String operacao = sc.nextLine();
                        if (operacao.equals("1")) {
                            System.out.println("\n" + user.solicitaAcesso(auth, nomeUsuario, senhaUsuario, nomeObjeto, "ler"));
                        } else if (operacao.equals("2")) {
                            System.out.println("\n" + user.solicitaAcesso(auth, nomeUsuario, senhaUsuario, nomeObjeto, "escrever"));
                        } else {
                            System.out.println("\nOpera��o inv�lida!");
                            break;
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
