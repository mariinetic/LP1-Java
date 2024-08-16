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