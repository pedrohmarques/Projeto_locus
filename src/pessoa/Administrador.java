package pessoa;

import Excecao.*;
import estruturadedados.Fila;
import evento.*;

import javax.swing.*;
import java.util.*;

public class Administrador implements CRUD{
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
    public boolean cadastrar(Object evento, String data, String hora)throws ExcecaoEventoJaCadastrado {
        boolean cadastrado = false;
        if(evento instanceof Evento){
            ((Evento) evento).setHorarioEvento(pegaData(data,hora));
            if(this.evento.contains(evento)){throw new ExcecaoEventoJaCadastrado();}
            else {
                ((Evento) evento).setIdEvento(this.evento.size()+1);
                this.evento.add((Evento)evento);
                cadastrado = true;
            }
        }

        return cadastrado;
    }

    @Override
    public boolean deletar(String id) {
        boolean deletado = false;
        for (int i = 0; i < evento.size(); i++) {
            Evento deletar = evento.get(i);
            if (deletar.getIdEvento() == Integer.parseInt(id)) {
                evento.remove(deletar);
                deletado = true;
            }
        }

        return false;
    }

    @Override
    public boolean editar(Object novosDados) {
        boolean editado = false;
        int index = -1;
        if (novosDados instanceof Evento) {
            for (int i = 0; i < evento.size(); i++) {
                Evento alterar = evento.get(i);
                int teste = alterar.getIdEvento();
                if (alterar.getIdEvento() == ((Evento) novosDados).getIdEvento()) {
                    index = evento.indexOf(alterar);
                }
            }
            if (index > -1) {
                evento.set(index,(Evento)novosDados);
                editado = true;
            }
        }
        return editado;
    }

    @Override
    public Object visualizar(String curso) {
       Fila fila = new Fila();
        for (int i = 0; i < evento.size(); i++) {
            Evento alterar = evento.get(i);
            if(alterar.getNomeCurso().equals(curso)){
                try{
                    fila.enfileira(alterar);
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error: Fila Cheia",
                            JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        }
        return fila;
    }
}
