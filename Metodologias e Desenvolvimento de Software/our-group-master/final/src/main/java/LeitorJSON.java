import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeitorJSON {

    //Esta função insere um objeto aula no array de aulas
    public static void parseAulasObject(JSONObject aulas, Aula[] aula){
        String data = (String) aulas.get("data");
        String hora = (String) aulas.get("hora");
        String Stempo = (String) aulas.get("tempo");
        String tipo = (String) aulas.get("tipo");
        String cadeiraID = (String) aulas.get("cadeiraID");
        String SaulaID = (String) aulas.get("aulaID");
        int IaulaID = Integer.parseInt(SaulaID);

        aula[IaulaID] = new Aula();
        aula[IaulaID].newAula(data, hora, Integer.parseInt(Stempo), tipo, cadeiraID, IaulaID);

    }

    //Esta função insere um objeto utilizador no array de utilizadores
    public static void parseDadosObject(JSONObject dados, Docente docente, Aluno[] alunos, String cadeiraID, int NumberofJustifications){

        String nome = (String) dados.get("nome");
        String Scartao = (String) dados.get("cartao");
        String papel = (String) dados.get("papel");
        String mail = (String) dados.get("mail");
        String pass = (String) dados.get("pass");
        int Icartao = Integer.parseInt(Scartao);

        User user = new User();
        if(papel.equals("aluno")){
            user.newUser(false, mail, nome, pass, Icartao);
            Justificacao[] justificacoes = new Justificacao[NumberofJustifications];

            alunos[Icartao] = new Aluno();
            alunos[Icartao].newAluno(user, justificacoes);

        }else{
            user.newUser(true, mail, nome, pass, Icartao);
            docente.newDocente(user, cadeiraID);
        }

    }

    //Esta função insere um objeto presenca no array de presenças
    public static void parsePresencasObject(JSONObject aulas, Presenca presenca){
        String Scartao = (String) aulas.get("cartao");
        String SaulaID = (String) aulas.get("aulaID");
        String Spresenca = (String) aulas.get("presenca");
        int Icartao = Integer.parseInt(Scartao);
        int IaulaID = Integer.parseInt(SaulaID);
        int Ipresenca = Integer.parseInt(Spresenca);

        presenca.changePresenca(IaulaID, Icartao, Ipresenca);
    }

    //Esta função lê do ficheiro JSON relativo às aulas
    public static void lerAulas(Aula[] aula){
        JSONParser parser = new JSONParser();
        try(FileReader reader = new FileReader("src/json/aulasMDS.json"))
        {
            //Read file
            Object obj = parser.parse(reader);
            JSONArray aulas = (JSONArray) obj;
            //Iterate over aulas array
            aulas.forEach(emp -> parseAulasObject( (JSONObject) emp, aula));


        }
        catch(FileNotFoundException e) { e.printStackTrace();}
        catch(IOException e) { e.printStackTrace();}
        catch(ParseException e) { e.printStackTrace();}
        catch(Exception e) { e.printStackTrace();}
    }

    //Esta função lê do ficheiro JSON relativo aos dados dos utilizadores
    public static void lerDados(Docente docente, Aluno[] alunos, String cadeiraID, int NumberofJustifications){
        JSONParser parser = new JSONParser();
        try(FileReader reader = new FileReader("src/json/mdadosMDS.json"))
        {
            //Read file
            Object obj = parser.parse(reader);
            JSONArray dados = (JSONArray) obj;
            //Iterate over aulas array
            dados.forEach(emp -> parseDadosObject( (JSONObject) emp, docente, alunos, cadeiraID, NumberofJustifications));


        }
        catch(FileNotFoundException e) { e.printStackTrace();}
        catch(IOException e) { e.printStackTrace();}
        catch(ParseException e) { e.printStackTrace();}
        catch(Exception e) { e.printStackTrace();}
    }

    //Esta função lê do ficheiro JSON relativo às presenças dos utilizadores
    public static void lerPresencas(Presenca presenca){
        JSONParser parser = new JSONParser();
        try(FileReader reader = new FileReader("src/json/Presencas.json"))
        {
            //Read file
            Object obj = parser.parse(reader);
            JSONArray dados = (JSONArray) obj;
            //Iterate over aulas array
            dados.forEach(emp -> parsePresencasObject( (JSONObject) emp, presenca));


        }
        catch(FileNotFoundException e) { e.printStackTrace();}
        catch(IOException e) { e.printStackTrace();}
        catch(ParseException e) { e.printStackTrace();}
        catch(Exception e) { e.printStackTrace();}
    }

    //Esta função cria um objeto Cadeira
    public static Cadeira iniciarCadeira(String cadeiraID, Docente docente, int NumberofAulas, int NumberofCartoes, int NumberofDocentes, int NumberofJustifications){

        Cadeira cadeira = new Cadeira();

        Aula[] aula = new Aula[NumberofAulas];
        lerAulas(aula);
        cadeira.changeAulas(aula);

        Aluno[] alunos = new Aluno[NumberofCartoes-NumberofDocentes];
        lerDados(docente, alunos, cadeiraID, NumberofJustifications);
        cadeira.changeAlunos(alunos);

        Presenca presenca = new Presenca();
        presenca.newPresenca(NumberofAulas, NumberofCartoes);
        lerPresencas(presenca);
        cadeira.changePresenca(presenca);

        return cadeira;
    }


}
