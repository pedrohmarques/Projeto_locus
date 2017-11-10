package AplicacaoTeste;

import Excecao.ExcecaoAlunoJaCadastrado;
import Excecao.ExcecaoEventoJaCadastrado;
import estruturadedados.Fila;
import evento.*;
import pessoa.Administrador;
import pessoa.Aluno;

import javax.swing.*;
import java.time.LocalDateTime;

public class
aplicacao {
    public static void main(String[] args) {
//        Aluno
        Aluno aluno = new Aluno("Engenharia", "tarde",
                5, "pedro","M","pedro","email");
//Evento
        Evento evento = new Evento("Modular","Hugo", 403, "Aula do hugao", "Engenharia" );
        Evento evento2 = new Evento("Modelagem","Hugo", 403, "Aula do hugao","Engenharia" );

        Curso curso = new Curso();
        Administrador adm = new Administrador();

        Fila fila = new Fila();


        try{
//            Exemplos de instancia...
//            Aluno
            curso.cadastrar(aluno,"14/04/1999", "14:00");
            //curso.editar(aluno);
            //curso.visualizar("email");

//            Evento:
            evento.setHorarioEvento(LocalDateTime.now());
            adm.cadastrar(evento);
            //adm.cadastrar(evento2,"15/06/2017","07:00");
            //adm.deletar(Integer.toString(2));
            //evento.setSala(802);
            //adm.editar(evento);
            //adm.visualizar("Engenharia");
        }catch (ExcecaoAlunoJaCadastrado e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error: Cadastro",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }catch (ExcecaoEventoJaCadastrado e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error: Cadastro",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error: Cadastro",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
