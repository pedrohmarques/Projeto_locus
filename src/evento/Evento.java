package evento;

import org.json.JSONObject;
import pessoa.Administrador;

import java.time.LocalDateTime;
import java.util.GregorianCalendar;

public class Evento {
    private Disciplina disciplina = new Disciplina();
    private int idEvento;
    private String horarioEvento;
    private Sala sala = new Sala();
    private String descricaoEvento;
    private Administrador adm;

    public Evento(){}
  /* public Evento(Administrador adm){
        this.adm = adm;
    } */

    public Evento(String horarioAula, String nomeDisciplina, String nomeProfessor, int sala, String descricaoEvento, String curso) {
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

    public String getHorarioEvento() {
        return horarioEvento;
    }

    public void setHorarioEvento(String horarioEvento) {
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

    public void setAdm(Administrador adm) {
        this.adm = adm;
    }

    public Administrador getAdm(){return adm;}

    public JSONObject toJSON(){

        JSONObject json = new JSONObject();

        json.put("id", getIdEvento());
        json.put("horarioAula", getHorarioEvento());
        json.put("disciplina", getDisciplina().getNomeDisciplina());
        json.put("sala", getSala());
        json.put("professor", getDisciplina().getNomeProfessor());
        json.put("curso", getDisciplina().getNomeCurso());
        json.put("descricao", getDescricaoEvento());

        return json;

    }
}
