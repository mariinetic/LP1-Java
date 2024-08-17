import java.util.Scanner;

public class EX4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o custo de fábrica:");
        double custo_fabrica = scanner.nextInt();

        double percentual_distribuidor = custo_fabrica * 28 / 100;
        double impostos = custo_fabrica * 45 / 100;
        double custo_final = custo_fabrica + percentual_distribuidor + impostos;

        System.out.println("O custo final ao consumidor é R$:" + custo_final);
    }
}
