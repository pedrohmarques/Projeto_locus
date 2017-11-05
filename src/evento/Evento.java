package evento;

import java.util.GregorianCalendar;

public class Evento extends Disciplina{
    private int idEvento;
    private GregorianCalendar horarioEvento;
    private Sala sala = new Sala();
    private String descricaoEvento;

    public Evento(){}

    public Evento(String nomeDisciplina, String nomeProfessor, int sala, String descricaoEvento) {
        super(nomeDisciplina, nomeProfessor);
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

    public GregorianCalendar getHorarioEvento() {
        return horarioEvento;
    }

    public void setHorarioEvento(GregorianCalendar horarioEvento) {
        this.horarioEvento = horarioEvento;
    }
}
