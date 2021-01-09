public class User {
    boolean docente;
    String mail;
    String nome;
    String password;
    int number;

    //Esta função cria um novo objeto User
    public void newUser(boolean docente, String mail, String nome, String password, int number) {
        this.docente = docente;
        this.mail = mail;
        this.nome = nome;
        this.password = password;
        this.number = number;
    }

    //Esta função devolve um inteiro Duracao do objeto Aluno
    public int getNumber() {
        return this.number;
    }

    //Esta função devolve uma String Password do objeto User
    public String getPassword() {
        return this.password;
    }

    //Esta função devolve uma String Nome do objeto User
    public String getNome() {
        return this.nome;
    }

    //Esta função devolve uma String Mail do objeto User
    public String getMail() {
        return this.mail;
    }

    //Esta função devolve um booleano IsDocente do objeto User
    public boolean getIsDocente() {
        return this.docente;
    }

    //Esta função modifica a String password do objeto User
    public void changePassword(String password) {
        this.password = password;
    }

    //Esta função devolve um valor boleano, unicamente para testes
    public boolean login(int number, String password){
        if(this.number==number && this.password==password)
            return true;
        return false;
    }
}