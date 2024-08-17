import java.util.Scanner;

public class EX15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de horas trabalhadas no mês: ");
        int hora_mes = scanner.nextInt();

        System.out.print("Digite seu salário por hora: ");
        int hora_salario = scanner.nextInt();

        int limite_horas = 160;
        double Total;

        if ( hora_mes > limite_horas ) {
            int horasExtras = hora_mes -limite_horas  ;
            double valorHoraExtra = hora_salario  * 1.5;
            Total = (limite_horas * hora_salario) + (horasExtras * valorHoraExtra);
        } else {
            Total = hora_mes * hora_salario;
        }

        System.out.print("Seu salário esse mês é R$: " + Total);
        scanner.close();
    }
}