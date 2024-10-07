package fatec.classes;

public class Sanrio {
    String nome;
    String comidaFav;
    String cor;
    int idade;

    public Sanrio(String _nome, String _comidaFav, String _cor, int _idade) {
        this.nome = _nome;
        this.comidaFav = _comidaFav;
        this.cor = _cor;
        this.idade = _idade;
    }
    
    public String getNome() {
        return this.nome;
    }
    public void setNome (String _nome) {
        this.nome = _nome;
    }
    public String getComidaFav() {
        return this.comidaFav;
    }
    public void setComidaFav (String _comidaFav) {
        this.comidaFav = _comidaFav;
    }
    public String getCor() {
        return this.cor;
    }
    public void setCor (String _cor) {
        this.cor = _cor;
    }
    public int getIdade() {
        return this.idade;
    }
    public void setCor (int _idade) {
        this.idade = _idade;
    }
    public String Brincar()
    {
        return (this.nome + " está feliz porque brincou");
    }
    public String Cozinhar()
    {
        return (this.nome + " está cozinhando " + this.comidaFav);
    }
}
