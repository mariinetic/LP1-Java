import java.util.Scanner;

public class EX2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o número dos eleitores totais:");
        int eleitores = scanner.nextInt();

        System.out.println("Digite os votos brancos:");
        int voto_branco = scanner.nextInt();

        System.out.println("Digite os votos nulos:");
        int voto_nulo = scanner.nextInt();

        System.out.println("Digite os votos válidos:");
        int voto_valido = scanner.nextInt();

        double percentual_vb = (double) voto_branco / eleitores * 100;
        double percentual_vn = (double) voto_nulo / eleitores * 100;
        double percentual_vv = (double) voto_valido / eleitores * 100;

        System.out.println("O percentual dos votos brancos são: " + percentual_vb + "%");
        System.out.println("O percentual dos votos nulos são: " + percentual_vn + "%");
        System.out.println("O percentual dos votos válidos são: " + percentual_vv + "%");

        scanner.close();
    }
}

/* Teste de Mesa:

| Passo | Descrição                                    | eleitores | voto_branco | voto_nulo | voto_valido | percentual_vb | percentual_vn | percentual_vv |                    Cálculo                      |        Resultado           |
|-------|----------------------------------------------|-----------|-------------|-----------|-------------|---------------|---------------|---------------|-------------------------------------------------|----------------------------|
| 1     | Entrada: Número dos eleitores totais         | 1000      |             |           |             |               |               |               |                                                 |                            |
| 2     | Entrada: Número de votos brancos             | 1000      | 200         |           |             |               |               |               |                                                 |                            |
| 3     | Entrada: Número de votos nulos               | 1000      | 200         | 100       |             |               |               |               |                                                 |                            |
| 4     | Entrada: Número de votos válidos             | 1000      | 200         | 100       | 700         |               |               |               |                                                 |                            |
| 5     | Calcular o percentual de votos brancos       | 1000      | 200         | 100       | 700         | 20.0%         |               |               | `(voto_branco / eleitores) * 100`               | 20.0%                      |
| 6     | Calcular o percentual de votos nulos         | 1000      | 200         | 100       | 700         | 20.0%         | 10.0%         |               | `(voto_nulo / eleitores) * 100`                 | 10.0%                      |
| 7     | Calcular o percentual de votos válidos       | 1000      | 200         | 100       | 700         | 20.0%         | 10.0%         | 70.0%         | `(voto_valido / eleitores) * 100`               | 70.0%                      |
| 8     | Exibir o percentual de votos brancos         | 1000      | 200         | 100       | 700         | 20.0%         | 10.0%         | 70.0%         |                                                 | "O percentual dos votos brancos são: 20.0%" |
| 9     | Exibir o percentual de votos nulos           | 1000      | 200         | 100       | 700         | 20.0%         | 10.0%         | 70.0%         |                                                 | "O percentual dos votos nulos são: 10.0%"   |
| 10    | Exibir o percentual de votos válidos         | 1000      | 200         | 100       | 700         | 20.0%         | 10.0%         | 70.0%         |                                                 | "O percentual dos votos válidos são: 70.0%" |

*/
