package pessoa;

import evento.Evento;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.awt.*;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class AdministradorTest {
    @Test
    public void ehAdministrador() throws Exception {
        Administrador adm = new Administrador();
        assertEquals(true, adm.ehAdministrador());
    }

    @Test
    public void cadastrar() throws Exception {
        Administrador adm = new Administrador();
        Evento evento = new Evento("Modular","Hugo", 403, "Aula do hugao", "Engenharia" );
        assertEquals(true, adm.cadastrar(evento));
    }

    @Test
    public void deletar() throws Exception {
        Administrador adm = new Administrador();
        Evento evento = new Evento("Modular","Hugo", 403, "Aula do hugao", "Engenharia" );
        Evento evento2 = new Evento("Modelagem","Hugo", 403, "Aula do hugao","Engenharia" );
        assertEquals(true, adm.deletar(2));
    }

    @Test
    public void editar() throws Exception {
        Administrador adm = new Administrador();
        Evento evento = new Evento("Modular","Hugo", 403, "Aula do hugao", "Engenharia" );
        assertEquals(true, adm.editar(evento));
    }

    @Test
    public void visualizar() throws Exception {
        Administrador adm = new Administrador();
        Evento evento = new Evento("Modular","Hugo", 403, "Aula do hugao", "Engenharia" );
        adm.cadastrar(evento);
        List<Evento> e = adm.visualizar("Engenharia");
        assertEquals(1, e.size());
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Administrador.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
