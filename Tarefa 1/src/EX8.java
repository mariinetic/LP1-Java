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
/* Teste de Mesa:

| Passo | Descrição                             | valor | Condição (valor >= 0) | Resultado           | 
|-------|---------------------------------------|-------|-----------------------|---------------------|
| 1     | Entrada: Digite um valor              | 5     | true                  | "É positivo."       | 
| 2     | Entrada: Digite um valor              | -3    | false                 | "É negativo."       |
| 3     | Entrada: Digite um valor              | 0     | true                  | "É positivo."       |

*/

