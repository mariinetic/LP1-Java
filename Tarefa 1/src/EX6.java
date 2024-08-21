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
/* Teste de Mesa:

| Passo | Descrição                                      | temperatura_F | temperatura_C |                        Cálculo                                  | Resultado                     |
|-------|------------------------------------------------|---------------|---------------|-----------------------------------------------------------------|-------------------------------|
| 1     | Entrada: Digite a temperatura em °F            | 98            |               |                                                                 |                               |
| 2     | Calcular a temperatura em °C                   | 98            |               | `(temperatura_F - 32) * 5 / 9`                                  | (98 - 32) * 5 / 9 = 36        |
| 3     | Exibir a temperatura em °C                     | 98            | 36            |                                                                 | "A temperatura é 36 °C"       |

*/

