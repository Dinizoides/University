public class Docente {

    User docente;
    String cadeiraID;

    //Esta função cria um novo objeto Docente
    public void newDocente(User docente, String cadeiraID){
        this.cadeiraID = cadeiraID;
        this.docente = docente;
    }

    //Esta função devolve o objeto Docente
    public User getDocente(){
        return this.docente;
    }

    //Esta função devolve uma string CadeiraID do objeto Docente
    public String getCadeiraID(){
        return this.cadeiraID;
    }

}
