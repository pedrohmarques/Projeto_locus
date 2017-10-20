package evento;

import sala.Sala;

public class Evento {
    private String horarioEvento;
    private Sala sala;
    private String descricaoEvento;

    public String dadosDeEvento(){

        return "fazer";
    }

    public void setDescricaoEvento(String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }

    public void setHorarioEvento(String horarioEvento) {
        this.horarioEvento = horarioEvento;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Sala getSala() {
        return sala;
    }

    public String getHorarioEvento() {
        return horarioEvento;
    }

    public String getDescricaoEvento() {
        return descricaoEvento;
    }
}
