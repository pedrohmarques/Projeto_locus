package evento;

import Excecao.ExcecaoAlunoJaCadastrado;
import pessoa.Aluno;
import pessoa.CRUD;

import java.util.GregorianCalendar;
import java.util.*;


public class Curso implements CRUD {
    private List<Aluno> aluno = new ArrayList<>();

    public Curso() {
    }

    private GregorianCalendar pegaData(String data, String hora) {
        GregorianCalendar dataADD = new GregorianCalendar();

        String[] parteData = data.split("/");
        int dia = Integer.parseInt(parteData[0]);
        int mes = Integer.parseInt(parteData[1]);
        int ano = Integer.parseInt(parteData[2]);

        String[] parteHora = hora.split(":");
        int hr = Integer.parseInt(parteHora[0]);
        int min = Integer.parseInt(parteHora[1]);

        dataADD.set(ano, mes, dia, hr, min);
        return dataADD;
    }

    @Override
    public boolean cadastrar(Object o, String data, String hora) throws ExcecaoAlunoJaCadastrado {
        boolean cadastrado = false;

        if (o instanceof Aluno) {
            ((Aluno) o).setDataNascimento(pegaData(data, hora));
            if (aluno.contains(o)) {
                throw new ExcecaoAlunoJaCadastrado(((Aluno) o).getNome());
            } else {
                aluno.add((Aluno) o);
                cadastrado = true;
            }
        }

        return cadastrado;
    }

    @Override
    public boolean deletar(String email) {
        boolean deletado = false;

        for (int i = 0; i < aluno.size(); i++) {
            Aluno deletar = aluno.get(i);
            if (deletar.getEmail().equals(email)) {
                aluno.remove(deletar);
                deletado = true;
            }
        }
        return deletado;
    }

    @Override
    public boolean editar(Object novosDados) {
        boolean editado = false;
        int index = -1;
        if (novosDados instanceof Aluno) {
            for (int i = 0; i < aluno.size(); i++) {
                Aluno alterar = aluno.get(i);
                if (alterar.getEmail().equals(((Aluno) novosDados).getEmail())) {
                    index = aluno.indexOf(alterar);
                }
            }
            if (index > -1) {
                aluno.set(index,(Aluno)novosDados);
                editado = true;
            }
        }
        return editado;
    }

    @Override
    public Object visualizar(String email) {
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
