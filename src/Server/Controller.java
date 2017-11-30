package Server;

import Excecao.*;
import evento.*;
import org.json.JSONArray;
import org.json.JSONObject;
import pessoa.*;

import java.io.PrintStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class Controller {
    private Administrador adm = new Administrador();
    private Aluno aluno;
    private Curso curso = new Curso();
    private Evento evento;


    public void cadastraEvento(String horarioAula, String nomeDisciplina, String nomeProfessor, String sala, String descricaoEvento, String curso) throws ExcecaoEventoJaCadastrado{

        evento = new Evento(horarioAula, nomeDisciplina, nomeProfessor, Integer.parseInt(sala), descricaoEvento,curso);
        boolean cadastrado = adm.cadastrar(evento);

        if(cadastrado){
            System.out.println("Evento cadastrado!");
        }else{
            System.out.println("Ocorreu um error ao cadastrar o evento!");
        }


    }

    public void deletarEvento(PrintStream body, String id){
        JSONObject json = new JSONObject();
        String tipo = "";
        String status = "Evento não encontrado";

        boolean deletado = adm.deletar(Integer.parseInt(id));

        if(deletado){
            tipo = "deletado";
            status = "OK";
        }

        json.put("status", status);
        json.put("tipo", tipo);
        json.put("operacao", "deletarEvento");

        body.println(json);
    }

    public void editarEvento(String id,String horarioAula, String nomeDisciplina, String nomeProfessor, String sala, String descricaoEvento, String curso){
        evento = new Evento(horarioAula, nomeDisciplina, nomeProfessor, Integer.parseInt(sala), descricaoEvento,curso);
        evento.setIdEvento(Integer.parseInt(id));
       boolean editado = adm.editar(evento);

       if(editado){
           System.out.println("Evento editado com sucesso!");
       }else{
           System.out.println("Evento editado com sucesso!");
       }


    }

    public void cadastrarAluno(PrintStream body, String curso, String turno, String periodo, String senha,String genero, String nome, String email) throws ExcecaoAlunoJaCadastrado {
       aluno = new Aluno(curso, turno, Integer.parseInt(periodo), senha, genero, nome, email);
        boolean cadastrado = this.curso.cadastrar(aluno);

        JSONObject json = new JSONObject();
        String tipo = "";
        String status = "Aluno não cadastrado";

        if(cadastrado){
            tipo = "cadastrado";
            status = "OK";
            System.out.println("Aluno Cadastrado com sucesso!");
        }else{
            System.out.println("Aluno não cadastrado!");
        }

        json.put("status", status);
        json.put("tipo", tipo);
        json.put("operacao", "cadastrarAluno");

        body.println(json);

    }

    public void deletarAluno(PrintStream body, String email){
        JSONObject json = new JSONObject();
        String tipo = "";
        String status = "Aluno não encontrado";

       boolean deletado =  this.curso.deletar(email);
        if(deletado){
            tipo = "deletado";
            status = "OK";
        }

        json.put("status", status);
        json.put("tipo", tipo);
        json.put("operacao", "deletarAluno");

        body.println(json);

    }

    public void editarAluno(String curso, String turno, String periodo, String senha,String genero, String nome, String email){
        aluno = new Aluno(curso, turno,Integer.parseInt(periodo), senha, genero, nome, email);
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
        json.put("operacao", "login");

        body.println(json);
    }


    public Evento mostrarEvento(){

            List<Evento> ev = adm.getEvento();
            for ( Evento evento : ev){
                this.evento = evento;
            }

        evento.setAdm(adm);
        return evento;
    }

    public Controller iniciarController() throws ExcecaoAlunoJaCadastrado, ExcecaoEventoJaCadastrado {
        Controller control = new Controller();
        aluno = new Aluno("dsa", "dsa", 4, "dsa","dsa", "dsa", "dsa");
        curso.cadastrar(aluno);

        evento = new Evento("23:59", "ProgramacaoModular", "Hugo de Paula", 503, "Aula sobre POO com o Hugao me da 2 ponto ai", "Engenharia de Software");
        adm.cadastrar(evento);
        return control;
    }
}
