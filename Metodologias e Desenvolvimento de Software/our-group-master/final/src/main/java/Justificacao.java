public class Justificacao{
	String data;
	String hora;
	String texto;
	boolean validade;
	boolean visto;

	//Esta função cria um novo objeto Justification
	public void newJustification(String data, String hora, String texto){
		this.data = data;
		this.hora = hora;
		this.texto = texto;
		this.validade = false;
		this.visto = false;
	}

	//Esta função modifica a validade do objeto Justificação
	public void changeValidade(boolean validade){
		this.validade = validade;
	}

	//Esta função modifica o visto do objeto Justificação
	public void changeVisto(boolean visto){
		this.visto = visto;
	}

	//Esta função devolve uma String Data do objeto Justificação
	public String getData(){
		return this.data;
	}

	//Esta função devolve uma String Hora do objeto Justificação
	public String getHora(){
		return this.hora;
	}

	//Esta função devolve uma String Texto do objeto Justificação
	public String getTexto(){
		return this.texto;
	}

	//Esta função devolve um booleano Duracao do objeto Justificação
	public boolean isValid(){
		return this.validade;
	}

	//Esta função devolve um booleano visto do objeto Justificação
	public boolean wasSeen(){
		return this.visto;
	}

}
