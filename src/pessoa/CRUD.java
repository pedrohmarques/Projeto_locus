package pessoa;

import Excecao.ExcecaoAlunoJaCadastrado;

import java.util.Set;

public interface CRUD {
    public boolean cadastrar(Object o, String data, String hora) throws ExcecaoAlunoJaCadastrado;
    public boolean deletar(String email);
    public boolean editar(Object novosDados);
    public void visualizar();
}
