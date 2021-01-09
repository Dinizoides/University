import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /////////////////////////////////////
        //Variáveis que podem ser alteradas

        //Variáveis(Globais)
        int NumberofAulas = 100;
        int NumberofCartoes = 200;
        int NumberofDocentes = 1;
        int NumberofJustifications = 100;

        //Variáveis responsáveis pela aula a ser executada
        String data = "2020-10-20", aula = "10:20", tipo = "Teorica";

        int tempoNormal = 60, aulaID = 25;

        /////////////////////////////////////
        /////////////////////////////////////


        LeitorDeCartoes leitor = new LeitorDeCartoes();
        GestaoDoSistema gestor = new GestaoDoSistema();
        Cadeira cadeira = new Cadeira();
        Docente docente = new Docente();

        boolean loop = true, Import = false;
        while(loop) {
            System.out.println("\n1: Selecionar aplicação LeitorDeCartoes\n2: Selecionar aplicação GestaoDoSistema\n0: Terminar o programa\n");
            Scanner input = new Scanner(System.in);

            while (!input.hasNextInt()) {
                System.out.println("Escolha uma das aplicações");
                input.next();
            }
            int choice = input.nextInt();
            switch (choice) {
                case (1):
                    if(Import)
                        leitor.runLeitorDeCartoes(cadeira, docente, NumberofCartoes, data, aula, tipo, tempoNormal, aulaID);
                    else
                        System.out.println("Leitor de Cartões não consegue registar cartões sem saber o papel dos utilizadores");
                    break;
                case (2):
                    gestor.runGestaoDoSistema(cadeira, docente, NumberofAulas, NumberofCartoes, NumberofDocentes, NumberofJustifications, Import);
                    cadeira = gestor.cadeira;
                    docente = gestor.docente;
                    Import = gestor.Import;
                    break;
                case (0):
                    loop = false;
                    break;
            }
        }
    }
}
