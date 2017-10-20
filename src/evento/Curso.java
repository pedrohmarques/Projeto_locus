package evento;

public class Curso {
    private String nomeCurso;

    public Curso(){}
    public Curso(String nomeCurso){
        setNomeCurso(nomeCurso);
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }
}
