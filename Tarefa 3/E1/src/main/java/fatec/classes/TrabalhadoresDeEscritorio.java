package fatec.classes;

public class TrabalhadoresDeEscritorio {
    private String nome;
    private String cargo;
    private double salario;

    public TrabalhadoresDeEscritorio(String _nome, String _cargo, double _salario) {
        this.nome = _nome;
        this.cargo = _cargo;
        this.salario = _salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    String compararCargo(TrabalhadoresDeEscritorio outro) {
        String retorno = "";
        if (this.cargo.equals(outro.cargo)) {
            retorno = "O " + this.nome + " tem o mesmo cargo que " + outro.nome;
        } else {
            retorno = "O " + this.nome + " não tem o mesmo cargo que " + outro.nome;
        }
        return retorno;
    }

    public String Trabalhar() {
        return(this.nome + " está trabalhando.");
    }

    public String ParticiparDeReuniao() {
        return(this.nome + " está participando de uma reunião.");
    }
}
