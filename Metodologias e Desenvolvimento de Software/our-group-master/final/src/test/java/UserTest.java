import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    User john = new User();

    @Before
    //Esta função cria um novo user para ser testado
    public void createUser(){
        john.newUser(true, "prof12@uevora.pt", "John", "24teacher7", 12);
    }
    
    @After
    //Esta função apaga o user que foi testado
    public void deleteUser(){
        john = null;
    }

    @Test
    //Esta função testa a função getIsDocente
    public void getIsDocenteTest(){
        assertEquals("The user John must be docente", true, john.getIsDocente());
    }

    @Test
    //Esta função testa a função changePassword
    public void changePasswordTest(){
        String senha = "oquequiser";
        john.changePassword(senha);
        assertEquals("The password was changed correctly", senha, john.getPassword());
    }

    @Test
    //Esta função testa a função getNome
    public void getNomeTest(){
        String name = "John";
        assertEquals("user must be named John", name, john.getNome());
    }

    @Test
    //Esta função testa a função getMail
    public void getMailTest(){
        String mail = "prof12@uevora.pt";
        assertEquals("user's email must be prof12@uevora.pt", mail, john.getMail());
    }

    @Test
    //Esta função testa a função getNumber
    public void getNumberTest(){
        int number = 12;
        assertEquals("user's number must be 12", number, john.getNumber());
    }

    @Test
    //Esta função testa a função login
    public void loginTest(){
        String pass = "24teacher7";
        int number = 12;
        assertTrue("login must be valid", john.login(number, pass));
    }

}