import java.util.Scanner;

public class Fracao {
    private int numerador;
    private int denominador;

    public Fracao(int numerador, int denominador) {
        if (denominador == 0) {
            throw new IllegalArgumentException("Denominador não pode ser zero.");
        }
        this.numerador = numerador;
        this.denominador = denominador;
        simplificar();
    }

    private void simplificar() {
        int mdc = mdc(Math.abs(numerador), Math.abs(denominador));
        numerador /= mdc;
        denominador /= mdc;

        if (denominador < 0) {
            numerador = -numerador;
            denominador = -denominador;
        }
    }

    private int mdc(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public Fracao somar(Fracao outra) {
        int novoNumerador = this.numerador * outra.denominador + outra.numerador * this.denominador;
        int novoDenominador = this.denominador * outra.denominador;
        return new Fracao(novoNumerador, novoDenominador);
    }

    public Fracao subtrair(Fracao outra) {
        int novoNumerador = this.numerador * outra.denominador - outra.numerador * this.denominador;
        int novoDenominador = this.denominador * outra.denominador;
        return new Fracao(novoNumerador, novoDenominador);
    }

    public Fracao multiplicar(Fracao outra) {
        int novoNumerador = this.numerador * outra.numerador;
        int novoDenominador = this.denominador * outra.denominador;
        return new Fracao(novoNumerador, novoDenominador);
    }

    public Fracao dividir(Fracao outra) {
        if (outra.numerador == 0) {
            throw new IllegalArgumentException("Não é possível dividir por zero.");
        }
        int novoNumerador = this.numerador * outra.denominador;
        int novoDenominador = this.denominador * outra.numerador;
        return new Fracao(novoNumerador, novoDenominador);
    }

    @Override
    public String toString() {
        if (denominador == 1) {
            return String.valueOf(numerador);
        } else {
            return numerador + "/" + denominador;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o numerador e denominador da primeira fração:");
        System.out.print("Numerador 1: ");
        int num1 = scanner.nextInt();
        System.out.print("Denominador 1: ");
        int den1 = scanner.nextInt();

        System.out.println("Digite o numerador e denominador da segunda fração:");
        System.out.print("Numerador 2: ");
        int num2 = scanner.nextInt();
        System.out.print("Denominador 2: ");
        int den2 = scanner.nextInt();

        Fracao f1 = new Fracao(num1, den1);
        Fracao f2 = new Fracao(num2, den2);

        int opcaoMenu;

        do { 
            System.out.println("1 - Soma");
            System.out.println("2 - Subtração");
            System.out.println("3 - Multiplicação");
            System.out.println("4 - Divisão");
            System.out.println("5 - Sair");
            System.out.print("Selecione uma opção: ");
            opcaoMenu = scanner.nextInt();

            switch (opcaoMenu) {
                case 1: 
                System.out.println("Soma: " + f1.somar(f2));
                break;
                case 2: 
                System.out.println("Subtração: " + f1.subtrair(f2));
                break;
                case 3: 
                System.out.println("Multiplicação: " + f1.multiplicar(f2));
                break;
                case 4: 
                System.out.println("Divisão: " + f1.dividir(f2));
                break;
                case 5:
                System.out.println("Saindo...");
                break;
                default:
                System.out.println("Opção inválida.");
            }
        } while (opcaoMenu != 5);

        scanner.close();
    }
}
