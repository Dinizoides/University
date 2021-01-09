import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PresencaTest {
    Presenca list = new Presenca();

    @Before
    //Esta função cria uma nova presença para ser testada
    public void createPresenca(){
        list.newPresenca(5,5);
        list.PresencaList[0][1]= 0;
        list.PresencaList[0][2]= 1;
        list.PresencaList[1][1]= 2;
        list.PresencaList[1][2]= 3;
        list.PresencaList[2][1]= 2;
        list.PresencaList[2][2]= 2;
    }

    @After
    //Esta função apaga a presença que foi testada
    public void deletePresenca(){
        list = null;
    }

    @Test
    //Esta função testa a função isJustified
    public void isJustifiedTest(){
        assertEquals("Your missing has been justified with sucess!", false, list.isJustified(0, 1));
        assertEquals("Your missing has been justified with sucess!", false, list.isJustified(0, 2));
        assertEquals("Your missing has been justified with sucess!", false, list.isJustified(1, 1));
        assertEquals("Your missing has been justified with sucess!", true, list.isJustified(1, 2));
        assertEquals("Your missing has been justified with sucess!", false, list.isJustified(2, 1));
        assertEquals("Your missing has been justified with sucess!", false, list.isJustified(2, 2));
    }

    @Test
    //Esta função testa a função isPresent
    public void isPresentTest(){
        assertEquals("You're present!", false, list.isPresent(0, 1));
        assertEquals("You're present!", true, list.isPresent(0, 2));
        assertEquals("You're present!", true, list.isPresent(1, 1));
        assertEquals("You're present!", false, list.isPresent(1, 2));
        assertEquals("You're present!", true, list.isPresent(2, 1));
        assertEquals("You're present!", true, list.isPresent(2, 2));
    }

    @Test
    //Esta função testa a função getPresent
    public void getPresentTest(){
        int valor = 0;
        assertEquals("Value should be 0", valor, list.getPresent(0, 1));
    }

    @Test
    //Esta função testa a função changePresenca
    public void changePresencaTest(){
        int valor = 1;
        list.changePresenca(0, 1, 1);
        assertEquals("Value should be 1", valor, list.getPresent(0, 1));
    }
}