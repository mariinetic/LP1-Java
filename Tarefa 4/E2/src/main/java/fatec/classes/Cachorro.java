package fatec.classes;

public class Cachorro {
    private String nome;
    private String raca;
    private double peso;
    private int idade;
    private int id;

    public Cachorro(String _nome, String _raca, double _peso) {
        this.nome = _nome;
        this.raca = _raca;
        this.peso = _peso;
    }
    public Cachorro(int _id, String _nome, String _raca, double _peso) {
        this.id = _id;
        this.nome = _nome;
        this.raca = _raca;
        this.peso = _peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    String compararRaca(Cachorro outro) {
        String retorno = "";
        if (this.raca.equals(outro.raca)) {
            retorno = "O " + this.nome + " é da mesma raça que " + outro.nome;
        } else {
            retorno = "O " + this.nome + " não é da mesma raça que " + outro.nome;
        }
        return retorno;
    }

    public String Latir() {
        return(this.nome + " está latindo.");
    }

    public String Correr() {
        return(this.nome + " está correndo.");
    }

    public int getId() {
        return (this.id);
    }
}
