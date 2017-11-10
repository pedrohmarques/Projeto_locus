package evento;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class CursoTest {
    @org.junit.Test
    public void cadastrar() throws Exception {

    }

    @org.junit.Test
    public void deletar() throws Exception {
    }

    @org.junit.Test
    public void editar() throws Exception {
    }

    @org.junit.Test
    public void visualizar() throws Exception {
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Curso.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
