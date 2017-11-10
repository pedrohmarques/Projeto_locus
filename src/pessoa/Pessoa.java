package pessoa;

import java.time.LocalDateTime;
import java.util.GregorianCalendar;

public abstract class Pessoa {

    private String nome;
    private LocalDateTime dataNascimento;
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

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
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
