package fatec.classes;

public class Planeta {
    private String nome;
    private double massa;
    private double diametro;
    private double distanciaDoSol;
    private boolean temAnel;
    private int id;

    public Planeta(String _nome, double _massa, double _diametro, double _distanciaDoSol, boolean _temAnel) {
        this.nome = _nome;
        this.massa = _massa;
        this.diametro = _diametro;
        this.distanciaDoSol = _distanciaDoSol;
        this.temAnel = _temAnel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getMassa() {
        return massa;
    }

    public void setMassa(double massa) {
        this.massa = massa;
    }

    public double getDiametro() {
        return diametro;
    }

    public void setDiametro(double diametro) {
        this.diametro = diametro;
    }

    public double getDistanciaDoSol() {
        return distanciaDoSol;
    }

    public void setDistanciaDoSol(double distanciaDoSol) {
        this.distanciaDoSol = distanciaDoSol;
    }

    public boolean isTemAnel() {
        return temAnel;
    }

    public void setTemAnel(boolean temAnel) {
        this.temAnel = temAnel;
    }

    String compararDistancia(Planeta outro) {
        if (this.distanciaDoSol > outro.distanciaDoSol) {
            return this.nome + " está mais distante do Sol do que " + outro.nome;
        } else if (this.distanciaDoSol < outro.distanciaDoSol) {
            return this.nome + " está mais próximo do Sol do que " + outro.nome;
        } else {
            return this.nome + " e " + outro.nome + " estão à mesma distância do Sol.";
        }
    }

    String compararMassa(Planeta outro) {
        if (this.massa > outro.massa) {
            return this.nome + " tem uma massa maior que " + outro.nome;
        } else if (this.massa < outro.massa) {
            return this.nome + " tem uma massa menor que " + outro.nome;
        } else {
            return this.nome + " e " + outro.nome + " têm a mesma massa.";
        }
    }

    public String Orbitar() {
        return(this.nome + " está orbitando o Sol.");
    }

    public String Girar() {
        return(this.nome + " está girando em seu eixo.");
    }
    public int getId() {
        return (this.id);
    }
}