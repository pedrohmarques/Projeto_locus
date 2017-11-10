package evento;

import java.time.LocalDateTime;
import java.util.GregorianCalendar;

public class Evento {
    private Disciplina disciplina = new Disciplina();
    private int idEvento;
    private LocalDateTime horarioEvento;
    private Sala sala = new Sala();
    private String descricaoEvento;

    public Evento(){}

    public Evento(LocalDateTime horarioAula, String nomeDisciplina, String nomeProfessor, int sala, String descricaoEvento, String curso) {
        setHorarioEvento(horarioAula);
        setDisciplina(nomeDisciplina,nomeProfessor,curso);
        setSala(sala);
        this.descricaoEvento = descricaoEvento;
    }

    public void setDescricaoEvento(String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }

    public void setSala(int sala) {
        this.sala.setNumSala(sala);
    }

    public void setIdEvento(int id) {
        this.idEvento = id;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public int getSala() {
        return sala.getNumSala();
    }

    public String getDescricaoEvento() {
        return descricaoEvento;
    }

    public LocalDateTime getHorarioEvento() {
        return horarioEvento;
    }

    public void setHorarioEvento(LocalDateTime horarioEvento) {
        this.horarioEvento = horarioEvento;
    }

    public void setDisciplina(String nomeDisciplina, String nomeProfessor, String nomeCurso) {
        this.disciplina.setNomeCurso(nomeCurso);
        this.disciplina.setNomeDisciplina(nomeDisciplina);
        this.disciplina.setNomeProfessor(nomeProfessor);
    }

    public Disciplina getDisciplina() {
        return this.disciplina;
    }
}
