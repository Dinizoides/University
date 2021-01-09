import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class AulaTest {

    Aula aula1 = new Aula();
    Aula aula2 = new Aula();
    Aula aula3 = new Aula();

    @Before
    //Esta função cria nova aulas para serem testadas
    public void createAula() {
        aula1.newAula("12/05/2020", "12:45", 120, "Pratica", "91F2D", 025);
        aula2.newAula("13/05/2020", "11:45", 120, "Teorica", "91F2D", 026);
        aula3.newAula("14/05/2020", "12:25", 120, "Pratica", "91F2D", 027);
    }

    @After
    //Esta função apaga as aulas que foram testadas
    public void deleteAula() {
        aula1 = null;
        aula2 = null;
        aula3 = null;
    }

    @Test
    //Esta função testa a função getData
    public void getDataTest() {
        assertEquals("The data must be equal", "12/05/2020", aula1.getData());
        assertEquals("The data must be equal", "13/05/2020", aula2.getData());
        assertEquals("The data must be equal", "14/05/2020", aula3.getData());
    }

    @Test
    //Esta função testa a função getHora
    public void getHoraTest() {
        assertEquals("The hora must be equal", "12:45", aula1.getHora());
        assertEquals("The hora must be equal", "11:45", aula2.getHora());
        assertEquals("The hora must be equal", "12:25", aula3.getHora());
    }

    @Test
    //Esta função testa a função getTipo
    public void getTipoTest() {
        assertEquals("The tipo must be equal", "Pratica", aula1.getTipo());
        assertEquals("The tipo must be equal", "Teorica", aula2.getTipo());
        assertEquals("The tipo must be equal", "Pratica", aula3.getTipo());
    }

    @Test
    //Esta função testa a função getCadeiraID
    public void getCadeiraIDTest() {
        assertEquals("The cadeiraID must be equal", "91F2D", aula1.getCadeiraID());
        assertEquals("The cadeiraID must be equal", "91F2D", aula2.getCadeiraID());
        assertEquals("The cadeiraID must be equal", "91F2D", aula3.getCadeiraID());
    }

    @Test
    //Esta função testa a função getDuracao
    public void getDuracaoTest() {
        assertEquals("The Duracao must be equal", 120, aula1.getDuracao());
        assertEquals("The Duracao must be equal", 120, aula2.getDuracao());
        assertEquals("The Duracao must be equal", 120, aula3.getDuracao());
    }

    @Test
    //Esta função testa a função getAulaID
    public void getAulaIDTest(){
        assertEquals("The aulaID must be equal", 120, aula1.getDuracao());
        assertEquals("The aulaID must be equal", 120, aula2.getDuracao());
        assertEquals("The aulaID must be equal", 120, aula3.getDuracao());
    }

    @Test
    //Esta função testa a função changeDuracao
    public void changeDuracaoTest(){
        int duracaoAula1 = 100, duracaoAula2 = 200, duracaoAula3 = 300;
        aula1.changeDuracao(duracaoAula1);
        aula2.changeDuracao(duracaoAula2);
        aula3.changeDuracao(duracaoAula3);

        assertEquals("The Duracao must be equal", duracaoAula1, aula1.getDuracao());
        assertEquals("The Duracao must be equal", duracaoAula2, aula2.getDuracao());
        assertEquals("The Duracao must be equal", duracaoAula3, aula3.getDuracao());
    }

}