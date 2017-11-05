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
        Aluno aluno = new Aluno("Engenharia", "tarde",
                5, "pedro","M","pedro","email");

        Evento evento = new Evento("Modular","Hugo", 403, "Aula do hugao" );

        Curso curso = new Curso();
        Administrador adm = new Administrador();

        try{
            curso.cadastrar(aluno,"14/04/1999", "14:00");
            adm.cadastrar(evento,"15/06/2017","07:00");

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
