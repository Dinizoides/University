import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DocenteTest {

    Docente professor = new Docente();

    @Before
    //Esta função cria um novo docente para ser testado
    public void createDocente() {
        User user = new User();
        user.newUser(true, "prof12@uevora.pt", "John", "24teacher7", 00012);

        professor.newDocente(user, "023232");
    }

    @After
    //Esta função apaga o docente que foi testado
    public void deleteDocente() {
        professor = null;
    }

    @Test
    //Esta função testa a função getDocente
    public void getDocenteTest() {

        User userTest = new User();
        userTest.newUser(true, "prof12@uevora.pt", "John", "24teacher7", 00012);

        boolean igual = true;
        if (userTest.equals(professor.getDocente()))
            igual = true;

        assertTrue("The aluno must be John", igual);
    }

    @Test
    //Esta função testa a função getCadeira
    public void getCadeiraIDTest() {
        assertEquals("The aluno must be John", "023232", professor.getCadeiraID());
    }

}