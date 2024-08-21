import java.util.Scanner;

public class EX12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int num1 = scanner.nextInt();

        System.out.print("Digite outro número: ");
        int num2 = scanner.nextInt();

        if(num1>num2){
            System.out.print("O maior valor é: " + num1);
        }
        else if (num2>num1){
            System.out.print("O maior valor é: " + num2);
        }
        else{
            System.out.print("Números iguais.");
        }
        scanner.close();
    }
}
/*

| Passo | Descrição                                    | num1 | num2 | Cálculo                  | Resultado                          |
|-------|----------------------------------------------|------|------|--------------------------|------------------------------------|
| 1     | Entrada: Primeiro número                     | 7    |      |                          |                                    |
| 2     | Entrada: Segundo número                      | 7    | 5    |                          |                                    |
| 3     | Verificar se num1 > num2                     | 7    | 5    | `7 > 5`                  | Verdadeiro (true)                  |
| 4     | Exibir mensagem: "O maior valor é: 7"        | 7    | 5    |                          | "O maior valor é: 7"               |
*/
