import java.util.Scanner;

public class EX14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Hora de início: ");
        int hora_Inicio = scanner.nextInt();

        System.out.print("Hora de fim: ");
        int hora_Fim = scanner.nextInt();


        int duracao;
        if (hora_Fim >= hora_Inicio) {

            duracao = hora_Fim - hora_Inicio;
        } else {

            duracao = (24 - hora_Inicio) + hora_Fim;
        }

        System.out.println("O jogo durou por " + duracao + " horas.");
        scanner.close();
    }
}

/*

| Passo | Descrição                                    | hora_Inicio | hora_Fim | Cálculo                           | Resultado                   |
|-------|----------------------------------------------|-------------|----------|-----------------------------------|-----------------------------|
| 1     | Entrada: Hora de início                      | 9           |          |                                   |                             |
| 2     | Entrada: Hora de fim                         | 17          | 17       |                                   |                             |
| 3     | Verificar se hora_Fim >= hora_Inicio         | 9           | 17       | `17 >= 9`                         | Verdadeiro (true)           |
| 4     | Calcular duração (hora_Fim - hora_Inicio)    | 9           | 17       | `17 - 9`                          | 8                           |
| 5     | Exibir mensagem: "O jogo durou por 8 horas." | 9           | 17       |                                   | "O jogo durou por 8 horas." |
*/
