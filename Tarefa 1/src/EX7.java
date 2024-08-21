import java.util.Scanner;

public class EX7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite    um valor: ");
        int valor = scanner.nextInt();

        String    resultado = (valor > 10) ? "É maior que 10!" : "Não é maior que 10!";
        System.out.println(resultado);

        scanner.close();
    }
}
/* Teste de Mesa:

| Passo | Descrição                                   | valor | resultado              |                        Cálculo                                   | Resultado                     |
|-------|---------------------------------------------|-------|------------------------|------------------------------------------------------------------|-------------------------------|
| 1     | Entrada: Digite um valor                    | 15    |                        |                                                                  |                               |
| 2     | Avaliar se o valor é maior que 10           | 15    |                        | `(valor > 10) ? "É maior que 10!" : "Não é maior que 10!"`       | "É maior que 10!"             |
| 3     | Exibir o resultado                          | 15    | "É maior que 10!"      |                                                                  | "É maior que 10!"             |

*/
