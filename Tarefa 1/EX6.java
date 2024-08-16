import java.util.Scanner;

public class EX6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a temperatura em °F: ");
        int temperatura_F = scanner.nextInt();

        int temperatura_C = (temperatura_F - 32) * 5 / 9;
        System.out.println("A temperatura é " + temperatura_C + " °C");

        scanner.close();
    }
}
