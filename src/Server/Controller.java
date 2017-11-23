package Server;

import Excecao.*;
import evento.*;
import org.json.JSONObject;
import pessoa.*;

import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.List;


public class Controller {
    private Administrador adm = new Administrador();
    private Aluno aluno;
    private Curso curso = new Curso();
    private Evento evento;


    public void cadastraEvento(LocalDateTime horarioAula, String nomeDisciplina, String nomeProfessor, int sala, String descricaoEvento, String curso) throws ExcecaoEventoJaCadastrado{
        evento = new Evento(horarioAula, nomeDisciplina, nomeProfessor, sala, descricaoEvento,curso);
        adm.cadastrar(evento);
    }

    public void deletarEvento(String id){

        adm.deletar(Integer.parseInt(id));
    }

    public void editarEvento(LocalDateTime horarioAula, String nomeDisciplina, String nomeProfessor, int sala, String descricaoEvento, String curso){
        evento = new Evento(horarioAula, nomeDisciplina, nomeProfessor, sala, descricaoEvento,curso);
        adm.editar(evento);
    }

    public void cadastrarAluno(String curso, String turno, int periodo, String senha,String genero, String nome, String email) throws ExcecaoAlunoJaCadastrado {
            aluno = new Aluno(curso, turno, periodo, senha, genero, nome, email);
            this.curso.cadastrar(aluno);
    }

    public void deletarAluno(String email){
        this.curso.deletar(email);
    }

    public void editarAluno(String curso, String turno, int periodo, String senha,String genero, String nome, String email){
        aluno = new Aluno(curso, turno, periodo, senha, genero, nome, email);
        this.curso.editar(aluno);
    }

    private boolean verificaPermisao(String email){
        if(email.equals(adm.getEmail())){
            return adm.ehAdministrador();
        }else{
            return false;
        }
    }

    public void realizandoCadastro(PrintStream body, String email, String senha){
        JSONObject json = new JSONObject();
        String tipo = "";
        String status = "Email ou senha incorretos";

        if(verificaPermisao(email)){
            if(adm.getSenha().equals(senha)){
                tipo = "administrador";
                status = "OK";
            }
        }else{
            aluno = curso.visualizar(email);
            if(aluno.getSenha().equals(senha)){
                tipo = "aluno";
                status = "OK";
            }
        }

        json.put("status", status);
        json.put("tipo", tipo);
        json.put("operacao", "realizarLogin");

        body.println(json);
    }
    public Controller iniciarController(){
        Controller control = new Controller();

        return control;
    }
}
