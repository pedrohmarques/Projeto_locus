package evento;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class EventoTest {
    @Test
    public void setDescricaoEvento() throws Exception {
    }

    @Test
    public void setSala() throws Exception {
    }

    @Test
    public void setIdEvento() throws Exception {
    }

    @Test
    public void setHorarioEvento() throws Exception {
    }

    @Test
    public void setDisciplina() throws Exception {
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Evento.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
