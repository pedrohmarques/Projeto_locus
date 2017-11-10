package evento;

import Excecao.ExcecaoAlunoJaCadastrado;
import pessoa.Aluno;

import java.time.LocalDateTime;
import java.util.GregorianCalendar;
import java.util.*;


public class Curso {
    private List<Aluno> aluno = new ArrayList<>();

    public Curso() {
    }

    public boolean cadastrar(Aluno a) throws ExcecaoAlunoJaCadastrado {
          if (aluno.contains(a)) {
                throw new ExcecaoAlunoJaCadastrado(a.getNome());
            } else {
                a.setDataNascimento(LocalDateTime.now());
                aluno.add(a);
                return true;
            }
        }

    public boolean deletar(String email) {
        for (int i = 0; i < aluno.size(); i++) {
            Aluno deletar = aluno.get(i);
            if (deletar.getEmail().equals(email)) {
                aluno.remove(deletar);
                return true;
            }
        }
        return false;
    }

    public boolean editar(Aluno novosDados) {
        int index = -1;
        for (int i = 0; i < aluno.size(); i++) {
            Aluno alterar = aluno.get(i);
            if (alterar.getEmail().equals((novosDados.getEmail()))) {
                    index = aluno.indexOf(alterar);
                }
            }
            if (index > -1) {
                aluno.set(index,novosDados);
                return true;
            }
        return false;
    }

    public Aluno visualizar(String email) {
        Aluno viewDados = new Aluno();
        for (int i = 0; i < aluno.size(); i++) {
            Aluno alterar = aluno.get(i);
            if(alterar.getEmail().equals(email)){
                viewDados.setCurso(alterar.getCurso());
                viewDados.setPeriodo(alterar.getPeriodo());
                viewDados.setTurno(alterar.getTurno());
                viewDados.setEmail(alterar.getEmail());
                viewDados.setDataNascimento(alterar.getDataNascimento());
                viewDados.setNome(alterar.getNome());
            }
        }
       return viewDados;
    }
}
