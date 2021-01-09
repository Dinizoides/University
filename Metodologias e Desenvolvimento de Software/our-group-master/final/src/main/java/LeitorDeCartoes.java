import java.util.Scanner;
import java.lang.*;

public class LeitorDeCartoes {

    //Execução da primeira aplicação
    public void runLeitorDeCartoes(Cadeira cadeira, Docente docente, int NumberofCartoes, String data, String aula, String tipo, int tempoNormal, int aulaID ) {

        boolean aulaAcabou = false, aulaComecou = false;


        while(!aulaComecou){
            System.out.println("\nEscreva um numero de cartao a passar no leitor");
            Scanner input = new Scanner(System.in);
            while (!input.hasNextInt())
                input.next();
            int number = input.nextInt();
            if(docente.docente.number == number){
                aulaComecou = true;
                criarAula(cadeira, data, aula, tipo, tempoNormal, aulaID);
                System.out.println("A aula começou");
            }else{
                System.out.println("Não há aulas para marcar presença");
            }
        }
        long tempoInicio = System.currentTimeMillis();

        while(!aulaAcabou){
            int number=-1;
            while(number<0 || number>NumberofCartoes){
                Scanner input = new Scanner(System.in);
                while (!input.hasNextInt())
                    input.next();
                number = input.nextInt();
            }

            //atualizar tempo
            long tempoFim = (System.currentTimeMillis() - tempoInicio)/1000;
            if(tempoFim > tempoNormal){
                System.out.println("A aula já acabou");
                break;
            }

            //Se o docente passar o cartão novamente, a aula acaba
            if(docente.docente.number == number){
                acabarAula(cadeira, (int)tempoFim, aulaID);
                break;
            }

            if(cadeira.alunos[number] != null){
                if(cadeira.presenca.isPresent(aulaID, number)) {
                    System.out.println("o aluno " +number+ " já se encontra presente");
                }else if(tempoFim < tempoNormal/2){
                    cadeira.presenca.changePresenca(aulaID, number, 2);
                    System.out.println("aluno com numero " + number + " entrou com presença");
                }else{
                    cadeira.presenca.changePresenca(aulaID, number, 1);
                    System.out.println("aluno com numero " + number + " entrou com meia-presença");
                }
            }else{
                System.out.println("aluno com numero " + number + " não pertence a esta cadeira");
            }
            //atualizar tempo
            tempoFim = (System.currentTimeMillis() - tempoInicio)/1000;

            if(tempoFim > tempoNormal){
                aulaAcabou = true;
            }

        }

    }

    //Esta função começa um objeto Aula da a lista de aulas
    public static void criarAula(Cadeira cadeira, String data, String hora, String tipo, int tempoNormal, int aulaID){
        cadeira.aulas[aulaID] = new Aula();
        cadeira.aulas[aulaID].newAula(data, hora, tempoNormal, tipo, cadeira.cadeiraID, aulaID);
    }

    //Esta função acaba um objeto Aula da a lista de aulas
    public static void acabarAula(Cadeira cadeira, int tempoTotal, int aulaID){
        cadeira.aulas[aulaID].changeDuracao(tempoTotal);
    }
}