import java.util.Scanner;

public class EX13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um valor: ");
        int val1 = scanner.nextInt();

        System.out.print("Digite outro valor: ");
        int val2 = scanner.nextInt();

        if(val1<val2){
            System.out.print("Em ordem crescente: " + val1 +", " + val2);
        }
        else if (val2<val1){
            System.out.print("O maior valor é: " + val2+ ", "+ val1);
        }
        else{
            System.out.print("Números iguais.");
        }
        scanner.close();
    }
}