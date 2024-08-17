import java.util.Scanner;

public class EX9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite    o total de maçãs: ");
        int totalMacas = scanner.nextInt();

        if (totalMacas >= 12) {
            int precoMacas = totalMacas * 1;
            System.out.println("A compra de maçãs será de R$: " + precoMacas);
        } else {
            double precoMacas = totalMacas * 1.3;
            System.out.println("A compra de maçãs será de R$: " + precoMacas);
        }

        scanner.close();
    }
}
