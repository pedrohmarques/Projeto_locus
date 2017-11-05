package pessoa;

import Excecao.*;
import evento.*;
import java.util.*;

public class Administrador implements CRUD{
    private String senha;
    private String email;
    private List<Evento> evento = new ArrayList<>();

    public Administrador(){}

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
                this.evento.add((Evento)evento);
                cadastrado = true;
            }
        }

        return cadastrado;
    }

    @Override
    public boolean deletar(String email) {
        return false;
    }

    @Override
    public boolean editar(Object novosDados) {
        return false;
    }

    @Override
    public Object visualizar(String descricao) {
        return null;
    }
}
