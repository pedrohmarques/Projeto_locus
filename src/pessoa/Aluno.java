package pessoa;

import java.util.*;
public class Aluno extends Pessoa{
    private String curso;
    private String turno;
    private int periodo;
    private String senha;

    public Aluno(){}

    public Aluno(String curso, String turno, int periodo, String senha,String genero, String nome, String email){
        super(nome,genero,email);
        setCurso(curso);
        setPeriodo(periodo);
        setTurno(turno);
        setSenha(senha);
    }
/*
    public String consultaAula(){

        return "fazer";
    }

    public Object consultarHorario(){
        Pessoa p = null;
        return p;
    }*/

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Aluno other = (Aluno) obj;
        if (this.getEmail() != other.getEmail())
            return false;
        return true;
    }
}
