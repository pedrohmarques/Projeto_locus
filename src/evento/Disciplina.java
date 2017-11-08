package evento;

public class Disciplina {
    private String nomeDisciplina;
    private String nomeProfessor;
    private String nomeCurso;

    public Disciplina(){}

    public Disciplina(String nomeDisciplina, String nomeProfessor, String nomeCurso) {
        setNomeProfessor(nomeProfessor);
        setNomeDisciplina(nomeDisciplina);
        setNomeCurso(nomeCurso);
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
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
