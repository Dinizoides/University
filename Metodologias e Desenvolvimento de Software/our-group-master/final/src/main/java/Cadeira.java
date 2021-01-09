public class Cadeira{

	String cadeiraID;
	Aula[] aulas;
	Aluno[] alunos;
	Presenca presenca;

	//Esta função cria um objeto Cadeira
	public void newCadeira(String cadeiraID, Aula[] aulas, Aluno[] alunos, Presenca presenca){
		this.cadeiraID = cadeiraID;
		this.aulas = aulas;
		this.alunos = alunos;
		this.presenca = presenca;
	}


	//Esta função devolve uma String CadeiraID do objeto Cadeira
	public String getCadeiraID(){
		return this.cadeiraID;
	}

	//Esta função devolve um array de objeto Aula do objeto Cadeira
	public Aula[] getAulas(){
		return this.aulas;
	}

	//Esta função devolve um array de objeto Alunos do objeto Cadeira
	public Aluno[] getAlunos(){
		return this.alunos;
	}

	//Esta função devolve um objeto Presenca do objeto Cadeira
	public Presenca getPresenca(){
		return this.presenca;
	}

	//Esta função modifica o array de aulas do objeto Cadeira
	public void changeAulas(Aula[] aulas){
		this.aulas = aulas;
	}

	//Esta função modifica o array de alunos do objeto Cadeira
	public void changeAlunos(Aluno[] alunos){
		this.alunos = alunos;
	}

	//Esta função modifica a CadeiraID do objeto Cadeira
	public void changeCadeiraID(String cadeiraID){
		this.cadeiraID = cadeiraID;
	}

	//Esta função modifica o objeto Presenca do objeto Cadeira
	public void changePresenca(Presenca presenca){
		this.presenca = presenca;
	}

	//Esta função devolve um inteiro que corresponde ao numero de alunos inscritos na Cadeira
	public int getNumberofAlunos(int TotalNumberofAlunos){
		int i;
		for(i=1; i<TotalNumberofAlunos; i++){
			if(this.alunos[i]==null) {
				break;
			}
		}
		return i-1;
	}

	//Esta função devolve um inteiro que corresponde ao numero de aulas feitas na Cadeira
	public int getNumberofAulas(int TotalNumberofAulas){
		int i;
		for(i=1; i<TotalNumberofAulas; i++){
			if(this.aulas[i]==null) {
				break;
			}
		}
		return i-1;
	}
}
