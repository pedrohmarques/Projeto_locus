package evento;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import pessoa.Administrador;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class EventoTest {
    @Test
    public void setDescricaoEvento() throws Exception {
        Evento evento = new Evento(LocalDateTime.now(),"Modular","Hugo", 403, "Aula do hugao", "Engenharia" );
        assertEquals("Aula do hugao", evento.getDescricaoEvento());
    }

    @Test
    public void setSala() throws Exception {
        Evento evento = new Evento(LocalDateTime.now(),"Modular","Hugo", 403, "Aula do hugao", "Engenharia" );
        assertEquals(403, evento.getSala() );
    }

    @Test
    public void setIdEvento() throws Exception {
        Administrador adm  = new Administrador();
        Evento evento = new Evento(LocalDateTime.now(),"Modular","Hugo", 403, "Aula do hugao", "Engenharia" );
        adm.cadastrar(evento);
        assertEquals(1,evento.getIdEvento());
    }

    @Test
    public void setHorarioEvento() throws Exception {
        Evento evento = new Evento(LocalDateTime.now(),"Modular","Hugo", 403, "Aula do hugao", "Engenharia" );
        assertEquals(LocalDateTime.now(), evento.getHorarioEvento());
    }

    @Test
    public void setDisciplina() throws Exception {
        Evento evento = new Evento(LocalDateTime.now(),"Modular","Hugo", 403, "Aula do hugao", "Engenharia" );
        assertEquals( "Modular",evento.getDisciplina());
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Evento.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
