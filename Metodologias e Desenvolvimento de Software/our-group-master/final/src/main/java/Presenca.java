public class Presenca{
	int[][] PresencaList;

	/*
	Valores postos na em cada posição da matriz presencaList:
	Caso 0: Falta
	Caso 1: Meia-presença
	Caso 2: Presença
	Caso 3: Falta Justificada
	*/


	//Esta função cria um novo objeto Presenca
	public void newPresenca(int naulas, int nalunos){
		this.PresencaList = new int[naulas][nalunos];
	}

	//Esta função modifica o valor posto na PresencaList
	public void changePresenca(int naulas, int nalunos, int valor){
		this.PresencaList[naulas][nalunos] = valor;
	}

	//Esta função devolve um booleano de acordo com a presenca justificada de uma posição na PresencaList
	public boolean isJustified(int naulas, int nalunos){
		if(this.PresencaList[naulas][nalunos]==3)
			return true;
		return false;
	}

	//Esta função devolve um booleano de acordo com a presenca de uma posição na PresencaList
	public boolean isPresent(int naulas, int nalunos){
		if(this.PresencaList[naulas][nalunos]==1 || this.PresencaList[naulas][nalunos]==2)
			return true;
		return false;
	}

	//Esta função devolve um inteiro que corresponde à presença numa posição da PresencaList
	public int getPresent(int naulas, int nalunos){
		return this.PresencaList[naulas][nalunos];
	}
}