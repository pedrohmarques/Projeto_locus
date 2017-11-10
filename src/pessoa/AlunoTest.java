package pessoa;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class AlunoTest {
    @Test
    public void ehAdministrador() throws Exception {
        Aluno aluno = new Aluno();
        assertEquals(false, aluno.ehAdministrador());
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Aluno.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
