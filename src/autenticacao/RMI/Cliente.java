package autenticacao.RMI;

import java.rmi.Naming;

import autenticacao.RMI.Administrador;

public class Cliente {

	public static void main(String[] args) {
		
		try {
			//obter objeto de forma remota
			Autenticacao autentic = (Autenticacao) Naming.lookup("localhost");
			
			//registrar um novo usuario
			autentic.registraUsuario("joao", "joao", "ler/escrever");
			
			
			
		} catch (Exception e) {
			
			
			
			
			
		}
		
		
		

	}
	

}
