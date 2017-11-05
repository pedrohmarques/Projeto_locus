package Excecao;

public class ExcecaoEventoJaCadastrado extends Exception{
    public ExcecaoEventoJaCadastrado(){
        super("Este evento ja foi cadastrado");
    }
}
