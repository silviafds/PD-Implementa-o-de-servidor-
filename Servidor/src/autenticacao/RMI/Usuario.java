package autenticacao.RMI;

import java.rmi.RemoteException;

public class Usuario {

    private String nome;
    private String senha;
    private boolean podeLer;

    private boolean podeEscrever;

    public  Usuario () {
    }

    public Usuario(String nome, String senha, boolean podeLer, boolean podeEscrever) {
        super();
        this.nome = nome;
        this.senha = senha;
        this.podeLer = podeLer;
        this.podeEscrever = podeEscrever;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isPodeLer() {
        return podeLer;
    }

    public void setPodeLer(boolean podeLer) {
        this.podeLer = podeLer;
    }

    public boolean isPodeEscrever() {
        return podeEscrever;
    }

    public void setPodeEscrever(boolean podeEscrever) {
        this.podeEscrever = podeEscrever;
    }

    public String solicitaAcesso(Autenticacao auth, String nome, String senha, String objeto, String operacao) throws RemoteException {
        return auth.solicitaAcesso(nome, senha, objeto, operacao);
    }
}
