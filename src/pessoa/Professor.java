package pessoa;

import evento.Disciplina;

public class Professor extends Pessoa{
    private Disciplina disciplina[];

    public Professor(){
        disciplina = new Disciplina[100];
    }

    public Professor(int tamVetor){
        disciplina = new Disciplina[tamVetor];
    }

    @Override
    public boolean cadastrar(String nome, String genero, int mes, int ano, int dia) {
        return false;
    }

    @Override
    public boolean deletar(int id) {
        return false;
    }

    @Override
    public boolean editar() {
        return false;
    }

    public void verificaDadoDisciplina(){

    }

    public void pegaDisciplina(Disciplina disciplina){

    }


}
