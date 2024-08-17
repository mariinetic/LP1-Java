import java.util.Scanner;

public class EX7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite    um valor: ");
        int valor = scanner.nextInt();

        String    resultado = (valor > 10) ? "É maior que 10!" : "Não é maior que 10!";
        System.out.println(resultado);

        scanner.close();
    }
}
