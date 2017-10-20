package evento;

public class Disciplina {
    private String nomeDisciplina;
    private String nomeProfessor;

    public Disciplina(){}

    public Disciplina(String nomeDisciplina, String nomeProfessor) {
        setNomeProfessor(nomeProfessor);
        setNomeDisciplina(nomeDisciplina);
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }
}
