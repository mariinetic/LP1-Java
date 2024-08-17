import java.util.Scanner;

public class EX10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a 1a: ");
        double nota_1 = scanner.nextInt();

        System.out.println("Digite a 2a: ");
        double nota_2 = scanner.nextInt();

        double media = (nota_1 + nota_2) / 2;

        if (media >= 6) {
            System.out.println("Aprovado! Com a nota: " + media);
        } else {
            System.out.println("Reprovado! Com a nota: " + media);
        }

        scanner.close();
    }
}
