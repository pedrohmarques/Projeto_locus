package pessoa;

import java.util.GregorianCalendar;

public abstract class Pessoa {

    private String nome;
    private GregorianCalendar dataNascimento;
    private String genero;
    private String email;

    public Pessoa(){}

    public Pessoa(String nome, String genero, String email){
        setNome(nome);
        setGenero(genero);
        setEmail(email);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public GregorianCalendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(GregorianCalendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
