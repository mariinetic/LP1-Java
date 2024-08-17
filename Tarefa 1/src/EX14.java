import java.util.Scanner;

public class EX14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Hora de início: ");
        int hora_Inicio = scanner.nextInt();

        System.out.print("Hora de fim: ");
        int hora_Fim = scanner.nextInt();


        int duracao;
        if (hora_Fim >= hora_Inicio) {

            duracao = hora_Fim - hora_Inicio;
        } else {

            duracao = (24 - hora_Inicio) + hora_Fim;
        }

        System.out.println("O jogo durou por " + duracao + " horas.");
        scanner.close();
    }
}