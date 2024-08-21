import java.util.Scanner;

public class EX4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o custo de fábrica:");
        double custo_fabrica = scanner.nextInt();

        double percentual_distribuidor = custo_fabrica * 28 / 100;
        double impostos = custo_fabrica * 45 / 100;
        double custo_final = custo_fabrica + percentual_distribuidor + impostos;

        System.out.println("O custo final ao consumidor é R$:" + custo_final);
    }
}

/* Teste de Mesa:

| Passo | Descrição                                | custo_fabrica | percentual_distribuidor | impostos | custo_final |                       Cálculo                                | Resultado                          |
|-------|------------------------------------------|---------------|-------------------------|----------|-------------|--------------------------------------------------------------|------------------------------------|
| 1     | Entrada: Digite o custo de fábrica       | 5000          |                         |          |             |                                                              |                                    |
| 2     | Calcular o percentual do distribuidor    | 5000          |                         |          |             | `custo_fabrica * 28 / 100`                                   | 5000 * 28 / 100 = 1400.0           |
| 3     | Calcular os impostos                     | 5000          | 1400.0                  |          |             | `custo_fabrica * 45 / 100`                                   | 5000 * 45 / 100 = 2250.0           |
| 4     | Calcular o custo final                   | 5000          | 1400.0                  | 2250.0   |             | `custo_fabrica + percentual_distribuidor + impostos`         | 5000 + 1400 + 2250 = 8650.0        |
| 5     | Exibir o custo final                     | 5000          | 1400.0                  | 2250.0   | 8650.0      |                                                              | "O custo final ao consumidor é R$: 8650.0"|

*/
