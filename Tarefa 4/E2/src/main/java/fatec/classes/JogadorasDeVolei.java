package fatec.classes;

public class JogadorasDeVolei {
    private String nome;
    private String posicao;
    private double altura;
    private int numeroCamisa;
    private int idade;
    private int id;

    public JogadorasDeVolei(String _nome, String _posicao, double _altura, int _numeroCamisa) {
        this.nome = _nome;
        this.posicao = _posicao;
        this.altura = _altura;
        this.numeroCamisa = _numeroCamisa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getNumeroCamisa() {
        return numeroCamisa;
    }

    public void setNumeroCamisa(int numeroCamisa) {
        this.numeroCamisa = numeroCamisa;
    }

    String compararAltura(JogadorasDeVolei outra) {
        if (this.altura > outra.altura) {
            return this.nome + " é mais alta que " + outra.nome;
        } else if (this.altura < outra.altura) {
            return this.nome + " é mais baixa que " + outra.nome;
        } else {
            return this.nome + " e " + outra.nome + " têm a mesma altura.";
        }
    }

    public String Sacar() {
        return (this.nome + " está sacando.");
    }

    public String Bloquear() {
        return (this.nome + " está bloqueando.");
    }

    public String Atacar() {
        return (this.nome + " está atacando.");
    }

    String compararPosicao(JogadorasDeVolei outra) {
        if (this.posicao.equals(outra.posicao)) {
            return this.nome + " joga na mesma posição que " + outra.nome;
        } else {
            return this.nome + " não joga na mesma posição que " + outra.nome;
        }
    }
    
    public int getId() {
        return (this.id);
    }
}
