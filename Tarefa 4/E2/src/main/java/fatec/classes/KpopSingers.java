package fatec.classes;

public class KpopSingers {
    private String nome;
    private int idade;
    private String grupo;
    private String corCabelo;
    private double altura;
    private int id;

    public KpopSingers(String _nome, int _idade, String _grupo) {
        this.nome = _nome;
        this.idade = _idade;
        this.grupo = _grupo;
    }
    public KpopSingers(int _id, String _nome, int _idade, String _grupo) {
        this.id = _id;
        this.nome = _nome;
        this.idade = _idade;
        this.grupo = _grupo;
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
    public int getId() {
        return (this.id);
    }
}