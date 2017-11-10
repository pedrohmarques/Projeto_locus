package pessoa;

import Excecao.ExcecaoAlunoJaCadastrado;
import Excecao.ExcecaoEventoJaCadastrado;

import java.util.Set;

public interface CRUD {
    public boolean cadastrar(Object o) throws ExcecaoAlunoJaCadastrado, ExcecaoEventoJaCadastrado;
    public boolean deletar(String dados);
    public boolean editar(Object novosDados);
    public Object visualizar(String descricao);
}
