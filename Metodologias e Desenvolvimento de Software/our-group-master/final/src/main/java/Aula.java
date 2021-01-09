public class Aula{
	String data;
	String hora;
	int duracao;
	String tipo;
	String cadeiraID;
	int aulaID;

	//Esta função cria um novo objeto Aula
	public void newAula(String data, String hora, int duracao, String tipo, String cadeiraID, int aulaID){
		this.data = data;
		this.hora = hora;
		this.duracao = duracao;
		this.tipo = tipo;
		this.cadeiraID = cadeiraID;
		this.aulaID = aulaID;
	}

	//Esta função devolve uma string Data do objeto Aluno
	public String getData(){
		return this.data;
	}

	//Esta função devolve uma string Hora do objeto Aluno
	public String getHora(){
		return this.hora;
	}

	//Esta função devolve uma string Tipo do objeto Aluno
	public String getTipo(){
		return this.tipo;
	}

	//Esta função devolve uma string CadeiraID do objeto Aluno
	public String getCadeiraID(){
		return this.cadeiraID;
	}

	//Esta função devolve um inteiro Duracao do objeto Aluno
	public int getDuracao(){
		return this.duracao;
	}

	//Esta função devolve um inteiro AulaID do objeto Aluno
	public int getAulaID(){
		return this.aulaID;
	}

	//Esta função modifica a duração de um objeto Aula
	public void changeDuracao(int duracao){
		this.duracao = duracao;
	}


}
