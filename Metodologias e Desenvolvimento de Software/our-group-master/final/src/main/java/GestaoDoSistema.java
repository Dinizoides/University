import java.util.Scanner;

public class GestaoDoSistema {
    Cadeira cadeira;
    Docente docente;
    boolean Import;

    //Execução da segunda aplicação e devolve um booleano de acordo com a importação dos utilizadores
    public void runGestaoDoSistema(Cadeira cadeira, Docente docente, int NumberofAulas, int NumberofCartoes, int NumberofDocentes, int NumberofJustifications, boolean Import) {
        this.Import = Import;
        this.cadeira = cadeira;
        this.docente = docente;

        boolean loop = true;
        Scanner input = new Scanner(System.in);

        while(loop) {
            System.out.println("\n1: Importar dados dos utilizadores \n2: Mostrar Relatório de Faltas\n3: Consultar faltas por aluno\n4: Justificar Falta\n0: Terminar a aplicação\n");

            while (!input.hasNextInt()){
                System.out.println("Escolha uma opção das quais estão descritas em cima");
                input.next();
            }
            int choice = input.nextInt();
            switch (choice) {
                case (1):
                    LeitorJSON leitorJSON = new LeitorJSON();
                    this.cadeira = leitorJSON.iniciarCadeira("MDS", this.docente, NumberofAulas, NumberofCartoes, NumberofDocentes, NumberofJustifications);
                    System.out.println("Importação de dados com sucesso");
                    this.Import = true;
                    break;
                case (2):
                    if (this.Import) {
                        Relatorio(this.cadeira, NumberofAulas, NumberofCartoes);
                    } else
                        System.out.println("Não houve importação de dados");
                    break;
                case (3):
                    if (this.Import) {

                        Consulta(input, this.cadeira, NumberofAulas, NumberofCartoes);
                    } else
                        System.out.println("Não houve importação de dados");
                    break;
                case (4):
                    if (this.Import) {
                        JustificarFalta(input, this.cadeira, NumberofJustifications, NumberofAulas, NumberofCartoes);
                    } else
                        System.out.println("Não houve importação de dados");
                    break;
                case (0):
                    System.out.println("A terminar a aplicação");
                    loop = false;
                    break;
                default:
                    System.out.println("Input não corresponde às opções descritas em cima");
            }
        }
    }

    //Esta função mostra ao utilizador o estado de presenças de todos os alunos na cadeira
    public static void Relatorio(Cadeira cadeira, int NumberofAulas, int NumberofCartoes){

        int Alunos = cadeira.getNumberofAlunos(NumberofCartoes), Aulas = cadeira.getNumberofAulas(NumberofAulas);
        System.out.println("\nTotal de Alunos: "+ Alunos);
        System.out.println("Total de Aulas: "+ Aulas);
        for(int i=1; i < Alunos; i++){
            int Presente=0;
            for(int j=1; j <= Aulas; j++){
                if(cadeira.presenca.isPresent(j,i)){
                    Presente+=cadeira.presenca.getPresent(j,i);
                }else if(cadeira.presenca.isJustified(j,i)){
                    Presente+=2;
                }
            }
            double Faltas = ((double)Aulas*2 - (double)Presente)/2;
            System.out.println("O aluno com número " + cadeira.alunos[i].aluno.number+ " tem " +Faltas+ " faltas em " +Aulas+ " aulas");
        }
    }

    //Esta função mostra ao utilizador o estado de presenças de um único aluno detalhadamente na cadeira

    public static void Consulta(Scanner input, Cadeira cadeira, int NumberofAulas, int NumberofCartoes){

        System.out.println("Escolha o aluno para consultar as suas faltas");
        while (!input.hasNextInt())
            input.next();
        int alunoID = input.nextInt();

        //Verificar se o aluno existe
        if(alunoID>cadeira.getNumberofAlunos(NumberofCartoes)){
            System.out.println("Aluno não existente");
            return;
        }

        System.out.println("O aluno com número " + alunoID + " :");

        for(int i=1; i< cadeira.getNumberofAulas(NumberofAulas); i++){
            System.out.print("-na aula do dia " + cadeira.aulas[i].getData() + " à hora " + cadeira.aulas[i].getHora());
            if(cadeira.presenca.isPresent(i,alunoID)){
                System.out.println(" esteve presente");
            }else if(cadeira.presenca.isJustified(i,alunoID)){
                System.out.println(" tem falta justificada");
            }else{
                System.out.println(" faltou");
            }
        }
    }

    //Esta função envia uma justificação por parte de um aluno ao docente
    public static void JustificarFalta(Scanner input, Cadeira cadeira, int NumberofJustifications, int NumberofAulas, int NumberofCartoes) {
        System.out.println("Escolha o aluno para justificar a falta:");
        while (!input.hasNextInt())
            input.next();
        int alunoID = input.nextInt();

        //Verificar se o aluno existe
        if(alunoID>cadeira.getNumberofAlunos(NumberofCartoes)){
            System.out.println("Aluno não existente");
            return;
        }

        System.out.println("Qual a aula a justificar?");
        while (!input.hasNextInt())
            input.next();
        int aulaID = input.nextInt();

        //Verificar se a aula existe
        if(aulaID>cadeira.getNumberofAulas(NumberofAulas)){
            System.out.println("Aula não existente");
            return;
        }

        if (cadeira.presenca.isPresent(aulaID, alunoID)) {
            System.out.println("O aluno com número " + alunoID+ " na aula do dia " +cadeira.aulas[aulaID].getData()+ " da hora " +cadeira.aulas[aulaID].getHora()+ " esteve presente");
        } else if (cadeira.presenca.isJustified(aulaID, alunoID)) {
            System.out.println("O aluno com número " + alunoID+ " na aula do dia " +cadeira.aulas[aulaID].getData()+ " da hora " +cadeira.aulas[aulaID].getHora()+ " tem falta justificada");
        } else {
            System.out.println("Escreva a justificação:");
            String texto  = input.next();
            cadeira.alunos[alunoID].getNewJustification(NumberofJustifications).newJustification(cadeira.aulas[aulaID].getData(),cadeira.aulas[aulaID].getHora(), texto);
            System.out.println("A justificação foi enviada");
        }
    }
}