package fatec.classes;

public class KpopSingers {
    private String nome;
    private int idade;
    private String grupo;
    private String corCabelo;
    private double altura;

    public KpopSingers(String _nome, int _idade, String _grupo, double altura) {
        this.nome = _nome;
        this.idade = _idade;
        this.grupo = _grupo;
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    String compararGrupo(KpopSingers outro) {
        String retorno = "";
        if (this.grupo == outro.grupo) {
            retorno = "O " + this.nome + " é do mesmo grupo que " + outro.nome;
        }
        else {
            retorno = "O " + this.nome + " não é do mesmo grupo que " + outro.nome;
        }
        return retorno;
    }
    public String Cantar() {
        return (this.nome + " está cantando.");
    }
    public String Dancar() {
        return (this.nome + " está dançando.");
    }
}
