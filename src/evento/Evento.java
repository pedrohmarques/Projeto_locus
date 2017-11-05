package evento;

import java.util.GregorianCalendar;

public class Evento extends Disciplina{
    private GregorianCalendar horarioEvento;
    private Sala sala;
    private String descricaoEvento;

    public Evento(){}

    public String dadosDeEvento(){

        return "fazer";
    }

    public void setDescricaoEvento(String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Sala getSala() {
        return sala;
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
