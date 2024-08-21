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
/* Teste de Mesa:

| Passo | Descrição                                | salario | reajuste | novo_salario |                     Cálculo                                |            Resultado              |
|-------|------------------------------------------|---------|----------|--------------|------------------------------------------------------------|-----------------------------------|
| 1     | Entrada: Digite o seu salário mensal     | 3000    |          |              |                                                            |                                   |
| 2     | Entrada: Digite o percentual de reajuste | 3000    | 10       |              |                                                            |                                   |
| 3     | Calcular o valor do reajuste             | 3000    | 10       |              | `salario * reajuste`                                       | 3000 * 10 = 30000                 |
| 4     | Dividir o valor do reajuste por 100      | 3000    | 10       |              | `30000 / 100`                                              | 30000 / 100 = 300.0               |
| 5     | Calcular o novo salário                  | 3000    | 10       | 3300.0       | `salario + (salario * reajuste / 100)`                     | 3000 + 300 = 3300.0               |
| 6     | Exibir o novo salário                    | 3000    | 10       | 3300.0       |                                                            | "Seu novo salário é R$: 3300.0"   |

*/
