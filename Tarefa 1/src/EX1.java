import java.util.Scanner;

public class EX1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite sua idade em anos:");
        int anos = scanner.nextInt();
        
        int a_dias = anos * 365;
        int meses = anos * 12;
        int m_dias = meses * 30;
        
        System.out.println("Sua idade em dias:" + a_dias);

        scanner.close();
    }
}

/* Teste de Mesa:

| Passo | Descrição                            | anos | meses | a_dias | m_dias | Cálculo                | Resultado |
|-------|--------------------------------------|------|-------|--------|--------|------------------------|-----------|
| 1     | Entrada: Idade em anos               | 2    |       |        |        |                        |           |
| 2     | Calcular meses baseados nos anos     | 2    | 24    |        |        | `anos * 12`            | 24        |
| 3     | Calcular dias baseados nos anos      | 2    | 24    | 730    |        | `anos * 365`           | 730       |
| 4     | Calcular dias baseados nos meses     | 2    | 24    | 730    | 720    | `meses * 30`           | 720       |
| 5     | Exibir resultado final               | 2    | 24    | 730    | 720    | `a_dias`               | 730       | */
