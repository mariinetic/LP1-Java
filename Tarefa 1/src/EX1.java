import java.util.Scanner;

public class EX1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite sua idade:");
        int anos = scanner.nextInt();

        int a_dias = anos * 365;
        int meses = anos * 12;
        int m_dias = meses * 30;

        int dias = a_dias + m_dias;

        System.out.println("Sua idade em dias:" + dias);
        scanner.close();
    }
}
