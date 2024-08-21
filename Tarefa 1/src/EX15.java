import java.util.Scanner;

public class EX15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de horas trabalhadas no mês: ");
        int hora_mes = scanner.nextInt();

        System.out.print("Digite seu salário por hora: ");
        int hora_salario = scanner.nextInt();

        int limite_horas = 160;
        double Total;

        if ( hora_mes > limite_horas ) {
            int horasExtras = hora_mes -limite_horas  ;
            double valorHoraExtra = hora_salario  * 1.5;
            Total = (limite_horas * hora_salario) + (horasExtras * valorHoraExtra);
        } else {
            Total = hora_mes * hora_salario;
        }

        System.out.print("Seu salário esse mês é R$: " + Total);
        scanner.close();
    }
}

/*


| Passo | Descrição                                     | hora_mes | hora_salario | Cálculo                                      | Resultado                     |
|-------|-----------------------------------------------|----------|--------------|----------------------------------------------|-------------------------------|
| 1     | Entrada: Número de horas trabalhadas no mês   | 170      |              |                                              |                               |
| 2     | Entrada: Salário por hora                     | 20       | 20           |                                              |                               |
| 3     | Verificar se hora_mes > limite_horas          | 170      | 20           | `170 > 160`                                  | Verdadeiro (true)             |
| 4     | Calcular horas extras                         | 170      | 20           | `170 - 160`                                  | 10                            |
| 5     | Calcular valor da hora extra                  | 170      | 20           | `20 * 1.5`                                   | 30                            |
| 6     | Calcular total com horas extras               | 170      | 20           | `(160 * 20) + (10 * 30)`                     | 3700                          |
| 7     | Exibir mensagem                               | 170      | 20           |                                              | "Seu salário esse mês é R$: 3700" |
*/
