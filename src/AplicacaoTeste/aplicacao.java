package AplicacaoTeste;

import Excecao.ExcecaoAlunoJaCadastrado;
import Excecao.ExcecaoEventoJaCadastrado;
import evento.*;
import pessoa.Administrador;
import pessoa.Aluno;

import javax.swing.*;

public class
aplicacao {
    public static void main(String[] args) {
//        Aluno
        Aluno aluno = new Aluno("Engenharia", "tarde",
                5, "pedro","M","pedro","email");
//Evento
        Evento evento = new Evento("Modular","Hugo", 403, "Aula do hugao" );
        Evento evento2 = new Evento("Modular","JOAO", 403, "Aula do hugao" );

        Curso curso = new Curso();
        Administrador adm = new Administrador();

        try{
//            Exemplos de instancia...
//            Aluno
            curso.cadastrar(aluno,"14/04/1999", "14:00");
            aluno.setNome("Lucas");
            curso.editar(aluno);
            curso.visualizar("email");

//            Evento:
            adm.cadastrar(evento,"15/06/2017","07:00");
            adm.cadastrar(evento2,"15/06/2017","07:00");
            //adm.deletar(Integer.toString(2));
            evento.setNomeProfessor("LUCAS");
            adm.editar(evento);
            adm.visualizar(Integer.toString(2));

        }catch (ExcecaoAlunoJaCadastrado e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error: Cadastro",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }catch (ExcecaoEventoJaCadastrado e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error: Cadastro",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
