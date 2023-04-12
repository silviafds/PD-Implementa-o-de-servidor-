package autenticacao.RMI;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
	
	public static void main(String[] args) { 
		
		try { 
			 Registry registry = LocateRegistry.createRegistry(1099); // rmi na porta 1099
			 
			 Autenticacao autenticacao = new AutenticacaoImpl();  //objeto criado
			 
			 Naming.bind("Autenticacao", autenticacao);
		} catch (RemoteException e) {
			System.out.println("Sistema com ERRO!!!!");
		}
		
	}
	
}
