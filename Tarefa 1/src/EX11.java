import java.util.Scanner;

public class EX11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o ano atual: ");
        int ano_atual = scanner.nextInt();

        System.out.print("Digite seu ano de nascimento: ");
        int ano_nascimento = scanner.nextInt();

        if(ano_atual-ano_nascimento>=16){
            System.out.print("Você poderá votar esse ano.");
        }
        else{
            System.out.print("Você não poderá votar esse ano.");
        }
        scanner.close();
}
}

/*

| Passo | Descrição                                    | ano_atual | ano_nascimento | Cálculo                  | Resultado                   |
|-------|----------------------------------------------|-----------|----------------|--------------------------|-----------------------------|
| 1     | Entrada: Ano atual                           | 2024      |                |                          |                             |
| 2     | Entrada: Ano de nascimento                   | 2024      | 2006           |                          |                             |
| 3     | Calcular a diferença entre anos              | 2024      | 2006           | `2024 - 2006`            | 18                          |
| 4     | Verificar se a diferença é >= 16             | 2024      | 2006           | `18 >= 16`               | Verdadeiro (true)           |
| 5     | Exibir mensagem:"Você poderá votar esse ano."| 2024      | 2006           |                          | "Você poderá votar esse ano." |
*/
