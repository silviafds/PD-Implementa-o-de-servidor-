package autenticacao.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import autenticacao.RMI.Usuario;

public class AutenticacaoImpl extends UnicastRemoteObject implements Autenticacao {
	
	//guarda os pares-chave valor em uma tabela
    private Map<String, String> usuario = new HashMap<>();
    private Map<String, String> permissao = new HashMap<>();

    private ArrayList<String> objetos = new ArrayList<>();


    public AutenticacaoImpl() throws RemoteException {
    }

    @Override
    public void registraUsuario(String nome, String senha, String permissao) throws RemoteException {
    	try {
    		Usuario usuario = new Usuario(nome, senha, permissao); //cadastrando usuario na classe usuario
    	} catch (Exception e) {
    		System.out.println("Erro ao registrar usuário na classe cliente");
            e.printStackTrace();
    	}
    	
        try {
            this.usuario.put(nome, senha);
            this.permissao.put(nome, permissao);
        } catch (Exception e) {
            System.out.println("Erro ao registrar usuário no map");
            e.printStackTrace();
        }
    }

    @Override
    public boolean solicitaAcesso(String nome, String senha, String objeto, String operacao) throws RemoteException {
        try {
            //verifica se o usuário existe e se a senha está correta
            String senhaUsuario = this.usuario.get(nome);
            if (senhaUsuario != null && senhaUsuario.equals(senha)) {

                //verifica se o usuário tem permissão para a operação
                String permissaoUsuario = this.permissao.get(nome);
                if (permissaoUsuario != null && permissaoUsuario.contains(operacao)){
                    //verifica se é solicitação de escrita e se o objeto ainda não existe
                    if (operacao.equals("escrita") && !objetos.contains(objeto)) objetos.add(objeto);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            System.out.println("Erro ao solicitar acesso");
            e.printStackTrace();
            return false;
        }
    }

    public void hello(String nome) throws RemoteException{
        System.out.println("Hello " + nome);
    }

}