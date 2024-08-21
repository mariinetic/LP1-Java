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
/* Teste de Mesa:

| Passo | Descrição                         | totalMacas | Condição (totalMacas >= 12)| Resultado                                |
|-------|-----------------------------------|------------|----------------------------|------------------------------------------|
| 1     | Entrada: Digite o total de maçãs  | 15         | true                       | "A compra de maçãs será de R$: 15"       |
| 2     | Entrada: Digite o total de maçãs  | 10         | false                      | "A compra de maçãs será de R$: 13.0"     |
| 3     | Entrada: Digite o total de maçãs  | 12         | true                       | "A compra de maçãs será de R$: 12"       |

*/
