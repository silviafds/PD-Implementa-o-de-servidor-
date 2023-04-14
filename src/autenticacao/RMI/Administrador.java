package autenticacao.RMI;

public class Administrador extends Usuario {
	
	private String identificador;
	
	

	public String getIdAdm() {
		return identificador;
	}


	public void setIdAdm(String idAdm) {
		this.identificador = idAdm;
	}


	public Administrador(String nome, String senha, String autorizacao, String identificador) {
		super(nome, senha, autorizacao);
		this.identificador = identificador;
		
	}
	
	
	
}
