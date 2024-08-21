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
/* Teste de Mesa:


| Passo | Descrição                                                | carros_vendidos | total_vendas | salario_fixo | comissao_fixa | salario_final |                       Cálculo                                | Resultado                           |
|-------|----------------------------------------------------------|-----------------|--------------|--------------|---------------|---------------|--------------------------------------------------------------|-------------------------------------|
| 1     | Entrada: Digite o número de carros vendidos              | 10              |              |              |               |               |                                                              |                                     |
| 2     | Entrada: Digite o valor total de suas vendas             | 10              | 100000       |              |               |               |                                                              |                                     |
| 3     | Entrada: Digite o seu salário fixo                       | 10              | 100000       | 2000         |               |               |                                                              |                                     |
| 4     | Entrada: Digite a comissão fixa                          | 10              | 100000       | 2000         | 500           |               |                                                              |                                     |
| 5     | Calcular o salário final                                 | 10              | 100000       | 2000         | 500           |               | `salario_fixo + (carros_vendidos * comissao_fixa) + (total_vendas * 5 / 100)` | 2000 + (10 * 500) + (100000 * 5 / 100) = 9500.0 |
| 6     | Exibir o salário final                                   | 10              | 100000       | 2000         | 500           | 9500.0        |                                                              | "O salário final do vendedor é R$: 9500.0"  |

*/

