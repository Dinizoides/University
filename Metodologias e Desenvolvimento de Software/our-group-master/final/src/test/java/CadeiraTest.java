import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CadeiraTest {

    Cadeira mds = new Cadeira();

    @Before
    //Esta função cria uma nova cadeira para ser testada
    public void createCadeira() {
        Aula[] aula = new Aula[2];
        aula[1] = new Aula();
        aula[1].newAula("12/05/2020", "12:45", 120, "Pratica", "91F2D", 012);

        User user = new User();
        user.newUser(true, "prof12@uevora.pt", "John", "24teacher7", 00012);

        Justificacao[] justificacoes = new Justificacao[1];
        justificacoes[0] = new Justificacao();
        justificacoes[0].newJustification("12/05/2020", "12:30", "faltei com razão");

        Aluno[] aluno = new Aluno[2];
        aluno[1] = new Aluno();
        aluno[1].newAluno(user, justificacoes);

        Presenca presenca = new Presenca();
        presenca.newPresenca(5,5);

        mds.newCadeira("MDS", aula, aluno, presenca);
    }

    @After
    //Esta função apaga a cadeira que foi testada
    public void deleteCadeira() {
        mds = null;
    }

    @Test
    //Esta função testa a função getCadeiraID
    public void getCadeiraIDTest() {
        assertEquals("The aluno must be John", "MDS", mds.getCadeiraID());
    }

    @Test
    //Esta função testa a função getAulas
    public void getAulasTest() {
        Aula[] aulaTest = new Aula[2];
        aulaTest[1] = new Aula();
        aulaTest[1].newAula("12/05/2020", "12:45", 120, "Pratica", "91F2D", 30);

        boolean validade = true;
        if (aulaTest.equals(mds.getAulas()))
            validade = true;

        assertTrue("The aluno must be John", validade);
    }

    @Test
    //Esta função testa a função getAlunos
    public void getAlunosTest() {

        User userTest = new User();
        userTest.newUser(true, "prof12@uevora.pt", "John", "24teacher7", 00012);

        Justificacao[] justificacoesTest = new Justificacao[1];
        justificacoesTest[0] = new Justificacao();
        justificacoesTest[0].newJustification("12/05/2020", "12:30", "faltei com razão");

        Aluno[] alunoTest = new Aluno[2];
        alunoTest[1] = new Aluno();
        alunoTest[1].newAluno(userTest, justificacoesTest);


        boolean validade = true;
        if (alunoTest.equals(mds.getAlunos()))
            validade = true;

        assertTrue("The aluno must be John", validade);
    }

    @Test
    //Esta função testa a função getPresenca
    public void getPresencaTest(){
        Presenca presenca = new Presenca();
        presenca.newPresenca(5,5);

        boolean validade = true;
        if (presenca.equals(mds.getPresenca()))
            validade = true;

        assertTrue("Presenca object should be the same", validade);
    }

    @Test
    //Esta função testa a função changeCadeiraID
    public void changeCadeiraIDTest(){
        String novoNome = "12345";
        mds.changeCadeiraID(novoNome);
        assertEquals("Changed CadeiraID should be ", novoNome, mds.getCadeiraID());
    }

    @Test
    //Esta função testa a função getNumberofAlunos
    public void getNumberofAlunosTest(){
        int numero = 1, numeroTotal = 2;
        assertEquals("Number of alunos should be 1 ", numero, mds.getNumberofAlunos(numeroTotal));
    }

    @Test
    //Esta função testa a função getNumberofAulas
    public void getNumberofAulasTest(){
        int numero = 1, numeroTotal = 2;
        assertEquals("Number of aulas should be 1 ", numero, mds.getNumberofAulas(numeroTotal));
    }

}
