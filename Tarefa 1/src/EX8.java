import java.util.Scanner;

public class EX8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um valor: ");
        int valor = scanner.nextInt();

        if (valor >= 0) {
            System.out.println("É positivo.");
        } else {
            System.out.println("É negativo.");   
        }

        scanner.close();
    }
}
