package AplicacaoTeste;

import Excecao.ExcecaoAlunoJaCadastrado;
import evento.Curso;
import pessoa.Aluno;

import javax.swing.*;

public class aplicacao {
    public static void main(String[] args) {
        Aluno aluno = new Aluno("Engenharia", "tarde",
                5, "pedro","M","pedro","email");

        Aluno aluno2 = new Aluno("Engenharia", "tarde",
                5, "pedro","M","pedro","joao");

        Curso curso = new Curso();
        try{
            curso.cadastrar(aluno,"14/04/1999", "14:00");
            curso.cadastrar(aluno2,"14/04/1999", "14:00");
            aluno.setCurso("deu");
            curso.editar(aluno);

        }catch (ExcecaoAlunoJaCadastrado e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error: Cadastro",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }
}
