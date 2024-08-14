public class Calculadora {

    // Atributos
    private int num1;
    private int num2;

    // Método construtor
    public Calculadora(int n1, int n2) {
        // Atributo recebe valor
        this.num1 = n1;
        this.num2 = n2;
    }

    public Calculadora(int n1, boolean v) {
        // Atributo recebe valor
        this.num1 = 8;
        this.num2 = 9;
    }

    public Calculadora() {
        // Atributo recebe valor
        this.num1 = 16;
        this.num2 = 23;
    }

    // Método de acesso * modificar o valor
    public void setNum1(int num1) {
        this.num1 = num1;
    }

    // Método de acesso * obter o valor
    public int getNum1() {
        return this.num1;
    }

    // Métodos
    public int somar1() {
        return num1 + num2;
    }

    public void somar2() {
        int resultado = num1 + num2;
        System.out.println(resultado);
    }

    public void subtrair() {
        int resultado = num1 - num2;
        System.out.println(resultado);
    }

    public static void main(String[] args) {
        // Declarando a variável / objeto
        Calculadora c1;

        // Criando o objeto / instância
        c1 = new Calculadora(10, 0);
        c1.somar2();

        // Declaração e instanciação do objeto c2
        Calculadora c2 = new Calculadora(10, 5);
        c2.subtrair();
        c2.setNum1(20);
        System.out.println("Novo valor de num1: " + c2.getNum1());
        c2.subtrair();
    }
}