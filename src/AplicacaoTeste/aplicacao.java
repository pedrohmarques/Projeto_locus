package AplicacaoTeste;

import Excecao.ExcecaoAlunoJaCadastrado;
import Excecao.ExcecaoEventoJaCadastrado;
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
        Evento evento = new Evento(LocalDateTime.now(),"Modular","Hugo", 403, "Aula do hugao", "Engenharia" );

        Curso curso = new Curso();
        Administrador adm = new Administrador();

        try{
//            Exemplos de instancia...
//            Aluno
            curso.cadastrar(aluno);
            //curso.editar(aluno);
            //curso.visualizar("email");

//            Evento:
            adm.cadastrar(evento);
            evento.setSala(802);
            adm.editar(evento);
            adm.visualizar("Engenharia");
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
