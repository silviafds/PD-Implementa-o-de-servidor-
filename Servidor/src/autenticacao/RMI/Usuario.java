package autenticacao.RMI;

public class Usuario {

    private String nome;
    private String senha;
    private String autorizacao;

    public Usuario() {
    }

    public Usuario(String nome, String senha, String autorizacao) {
        super();
        this.nome = nome;
        this.senha = senha;
        this.autorizacao = autorizacao;
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

    public String getAutorizacao() {
        return autorizacao;
    }

    public void setAutorizacao(String autorizacao) {
        this.autorizacao = autorizacao;
    }

}
