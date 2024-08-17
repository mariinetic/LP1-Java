import java.util.Scanner;

public class EX17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada das notas
        System.out.print("Digite a nota da sua P1: ");
        double P1 = scanner.nextDouble();

        System.out.print("Digite a nota do seu E1: ");
        double E1 = scanner.nextDouble();

        System.out.print("Digite a nota do seu E2: ");
        double E2 = scanner.nextDouble();

        System.out.print("Digite a nota da sua API: ");
        double API = scanner.nextDouble();

        System.out.print("Digite a nota das suas notas extras: ");
        double X = scanner.nextDouble();

        System.out.print("Digite a nota da sua SUB (Se tiver): ");
        double SUB = scanner.nextDouble();

        // Cálculo da média
        double mediaIntermediaria = P1 * 0.6 + ((E1 + E2) / 2) * 0.4;
        double media = (mediaIntermediaria * 0.5)
                + (Math.max((mediaIntermediaria - 5.9), 0) / (mediaIntermediaria - 5.9))
                * (API * 0.5)
                + X
                + (SUB * 0.2);

        // Exibição da média final
        System.out.printf("A sua média final é: %.2f%n", media);

        scanner.close();
    }
}
