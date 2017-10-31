package pessoa;

public class Administrador {
    private String senha;
    private String email;

    public Administrador(){}

    public Administrador(String senha, String email){
        setEmail(email);
        setSenha(senha);
    }

    public boolean cadastraEvento(Object evento){
        boolean sucesso = true;

        return true;
    }

    public void admCadastro(){

    }
    public boolean editarEvento(Object evento){
        boolean sucesso = true;

        return true;
    }

    public boolean deletarEvento(Object evento){
        boolean sucesso = true;

        return true;
    }

    public boolean ehAdministrador(){return true;}

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
