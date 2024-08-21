import java.util.Scanner;

public class EX1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite sua idade:");
        int anos = scanner.nextInt();

        int a_dias = anos * 365;
        int meses = anos * 12;
        int m_dias = meses * 30;

        int dias = a_dias + m_dias;

        System.out.println("Sua idade em dias:" + dias);
        scanner.close();
    }
}

/*Teste de mesa:

| Passo | Descrição                            | anos | meses | a_dias | m_dias | dias | Cálculo                | Resultado |
|-------|--------------------------------------|------|-------|--------|--------|------|------------------------|-----------|
| 1     | Entrada: Idade em anos               | 2    |       |        |        |      |                        |           |
| 2     | Calcular meses baseados nos anos     | 2    | 24    |        |        |      | `anos * 12`            | 24        |
| 3     | Calcular dias baseados nos anos      | 2    | 24    | 730    |        |      | `anos * 365`           | 730       |
| 4     | Calcular dias baseados nos meses     | 2    | 24    | 730    | 720    |      | `meses * 30`           | 720       |
| 5     | Adicionar dias diretamente           | 2    | 24    | 730    | 720    | 10   |                        | 10        |
| 6     | Somar todos os dias                  | 2    | 24    | 730    | 720    | 10   | `730 + 720 + 10`       | 1460      |
| 7     | Resultado final                      | 2    | 24    | 730    | 720    | 10   |                        | 1460      |*/
