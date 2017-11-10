package pessoa;

import estruturadedados.Fila;
import evento.Disciplina;
import evento.Evento;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Professor extends Pessoa{
    private List<Evento> evento = new ArrayList<>();
    private Fila dadosProfessor;

    public Professor(){
        dadosProfessor = new Fila();
    }

    public Object pegaDadosProfessor(List<Evento> lista, String nomeProfessor){
        evento = lista;
        for (int i = 0; i < evento.size(); i++) {
            Evento pegaDados = evento.get(i);
            if(pegaDados.getDisciplina().getNomeProfessor().equals(nomeProfessor)){
                try{
                    dadosProfessor.enfileira(pegaDados);
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error: Fila Cheia",
                            JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        }
        return dadosProfessor;
    }

    public Object pegaDisciplina(List<Evento> lista, String nomeProfessor){
        evento = lista;
        for (int i = 0; i < evento.size(); i++) {
            Evento pegaDados = evento.get(i);
            if(pegaDados.getDisciplina().getNomeProfessor().equals(nomeProfessor)){
                try{
                    dadosProfessor.enfileira(pegaDados.getDisciplina().getNomeProfessor());
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error: Fila Cheia",
                            JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        }
        return dadosProfessor;
    }


}
