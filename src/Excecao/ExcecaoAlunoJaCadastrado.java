package Excecao;

public class ExcecaoAlunoJaCadastrado extends Exception {
    public ExcecaoAlunoJaCadastrado(String nome){
        super(nome + " Já está cadastrado!");
    }
}
