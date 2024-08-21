import java.util.Scanner;

public class EX10 {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Digite a 1a: ");
    double nota_1 = scanner.nextInt();

    System.out.println("Digite a 2a: ");
    double nota_2 = scanner.nextInt();

    double media = (nota_1 + nota_2) / 2;

    if (media >= 6) {
        System.out.println("Aprovado! Com a nota: " + media);
    } else {
        System.out.println("Reprovado! Com a nota: " + media);
    }

    scanner.close();
}

/* Teste de Mesa

| Passo | Descrição                             | nota_1 | nota_2 | media | Condição (media >= 6) | Resultado                |
|-------|---------------------------------------|--------|--------|-------|-----------------------|--------------------------|
| 1     | Entrada: Primeira nota                | 8.0    |        |       |                       |                          |
| 2     | Entrada: Segunda nota                 | 8.0    | 7.0    |       |                       |                          |
| 3     | Calcular a média das notas            | 8.0    | 7.0    | 7.5   |                       |                          |
| 4     | If média é >=6                        | 8.0    | 7.0    | 7.5   | Verdadeiro            |                          |
| 5     | Resultado: Aprovado                   | 8.0    | 7.0    | 7.5   | Verdadeiro            | Aprovado! Com a nota: 7.5| */
