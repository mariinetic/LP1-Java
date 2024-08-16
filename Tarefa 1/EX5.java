import java.util.Scanner;

public class EX5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o número de carros vendidos: ");
        double carros_vendidos = scanner.nextDouble();

        System.out.println("Digite o valor total de suas vendas: ");
        double total_vendas = scanner.nextDouble();

        System.out.println("Digite o seu salário fixo: ");
        double salario_fixo = scanner.nextDouble();

        System.out.println("Digite a comissão fixa: ");
        double comissao_fixa = scanner.nextDouble();

        double salario_final = salario_fixo + (carros_vendidos * comissao_fixa) + (total_vendas * 5 / 100);
        System.out.println("O salário final do vendedor é R$: " + salario_final);

        scanner.close();
    }
}
