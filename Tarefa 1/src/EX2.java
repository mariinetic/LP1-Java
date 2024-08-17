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
