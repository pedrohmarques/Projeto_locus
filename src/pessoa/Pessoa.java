package pessoa;

import java.util.GregorianCalendar;

public abstract class Pessoa {

    private static int id;
    private String nome;
    private GregorianCalendar dataNascimento;
    private String genero;
    private String email;

    public Pessoa(){}

    public Pessoa(String nome, GregorianCalendar dataNascimento, String genero, String email) {
        setDataNascimento(dataNascimento);
        setEmail(email);
        setGenero(genero);
        setNome(nome);
        id++;
    }
//
//    public Object procurar(int id){
//
//        return Pessoa;
//    }

        public abstract boolean cadastrar(String nome, String genero, int mes, int ano, int dia);
        public abstract boolean deletar(int id);
        public abstract boolean editar();

    public static int getId() {
        return id;
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
