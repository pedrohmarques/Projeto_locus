package pessoa;

import evento.Disciplina;

public class Professor extends Pessoa{
    private Disciplina disciplina[];

    public Professor(){
        super();
        disciplina = new Disciplina[100];
    }

    public Professor(int tamVetor){
        super();
        disciplina = new Disciplina[tamVetor];
    }

    public void verificaDadoDisciplina(){

    }

    public void pegaDisciplina(Disciplina disciplina){

    }


}
