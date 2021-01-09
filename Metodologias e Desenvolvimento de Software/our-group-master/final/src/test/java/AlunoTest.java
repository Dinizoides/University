import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlunoTest {

    Aluno aluno = new Aluno();

    @Before
    //Esta função cria um novo aluno para ser testado
    public void createAluno(){
        User user = new User();
        user.newUser(false, "prof12@uevora.pt", "John", "24teacher7", 12);

        Justificacao[] justificacoes = new Justificacao[1];
        justificacoes[0] = new Justificacao();
        justificacoes[0].newJustification("12/05/2020", "12:30", "faltei com razão");

        aluno.newAluno(user, justificacoes);
    }

    @After
    //Esta função apaga o aluno que foi testado
    public void deleteAluno() {
        aluno = null;
    }

    @Test
    //Esta função testa a função getAluno
    public void getAlunoTest() {

        User userTest = new User();
        userTest.newUser(false, "prof12@uevora.pt", "John", "24teacher7", 00012);

        boolean validade = true;
        if (userTest.equals(aluno.getAluno()))
            validade = true;

        assertTrue("The aluno must be John", validade);

    }

    @Test
    //Esta função testa a função getListaJustificacoes
    public void getListaJustificacoesTest() {
        Justificacao[] justifications = new Justificacao[1];
        justifications[0] = new Justificacao();
        justifications[0].newJustification("12/05/2020", "12:30", "faltei com razão");

        boolean validade = true;
        if (justifications.equals(aluno.getListaJustificacoes()))
            validade = true;

        assertTrue("The aluno must be John", validade);
    }

    @Test
    //Esta função testa a função getNewJustification
    public void getNewJustificationTest() {
        int NumberofJustifications = 0;
        Justificacao justifications = new Justificacao();

        boolean validade = true;
        if (justifications.equals(aluno.getNewJustification(NumberofJustifications)))
            validade = true;

        assertTrue("The aluno must be John", validade);
    }

}
