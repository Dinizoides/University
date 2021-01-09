public class Aluno{

	User aluno;
	Justificacao[] listaJustificacoes;

	//Esta função cria um novo objeto aluno
	public void newAluno(User aluno, Justificacao[] listaJustificacoes){
		this.aluno = aluno;
		this.listaJustificacoes = listaJustificacoes;
	}

	//Esta função devolve o objeto User do objeto Aluno
	public User getAluno(){
		return this.aluno;
	}

	//Esta função devolve um array de objetos Justificacao do objeto Aluno
	public Justificacao[] getListaJustificacoes(){
		return this.listaJustificacoes;
	}

	//Esta função cria um novo objeto Justificacao no objeto Aluno
	public Justificacao getNewJustification(int NumberofJustifications){
		int i;
		for(i=0; i<NumberofJustifications; i++){
			if(listaJustificacoes[i]==null){
				break;
			}
		}
		listaJustificacoes[i]= new Justificacao();
		return listaJustificacoes[i];
	}

}
