package pessoa;

import Excecao.ExcecaoAlunoJaCadastrado;
import Excecao.ExcecaoEventoJaCadastrado;

import java.util.Set;

public interface CRUD {
    public boolean cadastrar(Object o, String data, String hora) throws ExcecaoAlunoJaCadastrado, ExcecaoEventoJaCadastrado;
    public boolean deletar(String email);
    public boolean editar(Object novosDados);
    public Object visualizar(String descricao);
}
