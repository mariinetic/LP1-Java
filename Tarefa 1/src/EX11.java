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