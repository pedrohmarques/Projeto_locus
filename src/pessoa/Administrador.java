package pessoa;

import Excecao.*;
import evento.*;

import javax.swing.*;
import java.util.*;

public class Administrador{
    private String senha;
    private String email;
    private List<Evento> evento = new ArrayList<>();

    public Administrador(){
        setEmail("testeservidor@gmail.com");
        setSenha("locus123");
    }

    public Administrador(String senha, String email){
        setEmail(email);
        setSenha(senha);
    }

    public boolean ehAdministrador(){return true;}

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    private Evento verificaIdDisponivel(Evento evento){
        boolean disponivel = false;
        for (int i = 0; i < this.evento.size(); i++) {
            Evento verificar = this.evento.get(i);
            if(verificar.getIdEvento() == (i+1)){
                disponivel = true;
            }else{
                disponivel = false;
            }
        }
        if(disponivel){
            evento.setIdEvento(this.evento.size() + 1);
        }else{
            evento.setIdEvento(this.evento.size());
        }

        return evento;
    }

    public boolean cadastrar(Evento evento)throws ExcecaoEventoJaCadastrado {
        if(this.evento.contains(evento)){throw new ExcecaoEventoJaCadastrado();}
            else {
            evento = verificaIdDisponivel(evento);
            this.evento.add(evento);
            return true;
        }
    }

    public boolean deletar(int id) {
        for (int i = 0; i < evento.size(); i++) {
            Evento deletar = evento.get(i);
            if (deletar.getIdEvento() == id) {
                evento.remove(deletar);
                return true;
            }
        }

        return false;
    }

    public boolean editar(Evento novosDados) {
        int index = -1;
        for (int i = 0; i < evento.size(); i++) {
                Evento alterar = evento.get(i);
                int teste = alterar.getIdEvento();
                if (alterar.getIdEvento() == (novosDados).getIdEvento()) {
                    index = evento.indexOf(alterar);
                }
            }
            if (index > -1) {
                evento.set(index,(Evento)novosDados);
                return true;
            }
        return false;
    }

    public List<Evento> visualizar(String curso) {
        List<Evento> evento = new ArrayList<>();
       for (int i = 0; i < this.evento.size(); i++) {
            Evento visualizar = this.evento.get(i);
            if(visualizar.getDisciplina().getNomeCurso().equals(curso)){
                evento.add(visualizar);
            }
        }
        return evento;
    }
}
