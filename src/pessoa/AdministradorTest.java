package pessoa;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class AdministradorTest {
    @Test
    public void ehAdministrador() throws Exception {
    }

    @Test
    public void cadastrar() throws Exception {
    }

    @Test
    public void deletar() throws Exception {
    }

    @Test
    public void editar() throws Exception {
    }

    @Test
    public void visualizar() throws Exception {
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Administrador.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
