package evento;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;
import pessoa.Aluno;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class CursoTest {
    @org.junit.Test
    public void cadastrar() throws Exception {
        Curso curso = new Curso();
        Aluno aluno = new Aluno("Engenharia", "tarde",
                5, "pedro","M","pedro","email");
        assertEquals(true, curso.cadastrar(aluno));
    }

    @org.junit.Test
    public void deletar() throws Exception {
        Curso curso = new Curso();
        Aluno aluno = new Aluno("Engenharia", "tarde",
                5, "pedro","M","pedro","email");
        curso.cadastrar(aluno);
        assertEquals(true, curso.deletar("email"));
    }

    @org.junit.Test
    public void editar() throws Exception {
        Curso curso = new Curso();
        Aluno aluno = new Aluno("Engenharia", "tarde",
                5, "pedro","M","pedro","email");
        curso.cadastrar(aluno);
        aluno.setNome("Joao");
        assertEquals(true, curso.editar(aluno));
    }

    @org.junit.Test
    public void visualizar() throws Exception {
        Curso curso = new Curso();
        Aluno aluno = new Aluno("Engenharia", "tarde",
                5, "pedro","M","pedro","email");
        curso.cadastrar(aluno);
        Aluno a = curso.visualizar("email");
        //assertEquals(, a);
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Curso.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
