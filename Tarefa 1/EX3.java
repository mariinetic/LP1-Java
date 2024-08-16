import java.util.Scanner;

public class EX3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o seu salário mensal:");
        double salario = scanner.nextInt();

        System.out.println("Digite o percentual de reajuste:");
        double reajuste = scanner.nextInt();

        double novo_salario = salario + (salario * reajuste / 100);
        System.out.println("Seu novo salário é R$:" + novo_salario);

        scanner.close();
    }
}
