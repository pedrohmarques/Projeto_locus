package pessoa;

import evento.Curso;
import evento.Disciplina;
import evento.Evento;
import java.util.ArrayList;
import java.util.List;

public class Professor extends Pessoa{
    private List<Evento> eventos = new ArrayList<>();
    private Curso curso;
    private List<Disciplina> disciplinas = new ArrayList<>();

    public List<Evento> getEvento() {
        return eventos;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public Professor(){ }

    public void addEvento(Evento e){
        eventos.add(e);
    }

    public void addDisciplina(Disciplina d){
        disciplinas.add(d);
    }



}
