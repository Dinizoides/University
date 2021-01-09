import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JustificacaoTest{
	
	Justificacao justificacao1 = new Justificacao();

	@Before
	//Esta função cria uma nova justificação para ser testada
	public void createJustification() {
		justificacao1.newJustification("12/05/2020", "12:30", "faltei com razão");
	}

	@After
	//Esta função apaga a justificação que foi testada
	public void deleteJustification() {
		justificacao1 = null;
	}

	@Test
	//Esta função testa a função changeValidade
	public void changeValidadeTest() {
		justificacao1.changeValidade(true);
		assertEquals("The justification must be valid", true, justificacao1.isValid());
	}

	@Test
	//Esta função testa a função changeVisto
	public void changeVistoTest() {
		justificacao1.changeVisto(true);
		assertEquals("The justification must be seen", true, justificacao1.wasSeen());
	}

	@Test
	//Esta função testa a função isValid
	public void isValidTest() {
		assertFalse("The justification must be invalid", justificacao1.isValid());
	}

	@Test
	//Esta função testa a função getData
	public void getDataTest(){
		String Data = "12/05/2020";
		assertEquals("The justification' date must be 12/05/2020", Data, justificacao1.getData());
	}

	@Test
	//Esta função testa a função getHora
	public void getHoraTest(){
		String Hora = "12:30";
		assertEquals("The justification's time must be 12:30", Hora, justificacao1.getHora());
	}

	@Test
	//Esta função testa a função getTexto
	public void getTextoTest(){
		String Texto = "faltei com razão";
		assertEquals("The justification' text must be 'faltei com razão'", Texto, justificacao1.getTexto());
	}

}