package autenticacao.RMI;

import autenticacao.RMI.Autenticacao;

import java.rmi.Naming;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            //obter objeto de forma remota
            Autenticacao auth = (Autenticacao) Naming.lookup("rmi://127.0.0.1:1099/AutenticacaoImpl");

            //registrar um novo usuario
            auth.registraUsuario("joao", "joao", "ler/escrever");

            System.out.println("Esperando...");
            auth.hello("joao");

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();

        }

    }
}
