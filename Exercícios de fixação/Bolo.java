public class Bolo {
    // atributos
    String sabor;
    Boolean assado;
    Boolean cobertura;
    Boolean recheio;
    Double peso;

    // métodos
    public void assar() {
        System.out.println("Bolo está assado");
        assado = true;
    }

    public Bolo() {
        sabor = "chocolate";
        assado = false;
    }

    public Boolean estaPronto() {
        return assado;
    }

    public void main(String[] args) {
        Bolo b1 = new Bolo();
        b1.sabor = "Baunilha";

        Bolo b2 = new Bolo();
        b2.assar();
    }
}
