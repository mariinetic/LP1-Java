package fatec.classes;
public class Salgadinhos
{
    String sabor;
    double peso;
    int qtnde;

    public Salgadinhos(String _sabor, double _peso, int _qtnde) {
        this.sabor = _sabor;
        this.peso = _peso;
        this.qtnde = _qtnde;
    }
    public String getSabor() {
        return this.sabor;
    }
    public void setSabor(String _sabor) {
        this.sabor = _sabor;
    }
    public double getPeso() {
        return this.peso;
    }
    public void setPeso(Float _peso) {
        this.peso = _peso;
    }
    public double getQtnde() {
        return this.qtnde;
    }
    public void setQtnde(int _qtnde) {
        this.qtnde = _qtnde;
    }
    public void compararPeso(Salgadinhos outro) {
        String retorno = "";
        if (this.peso > outro.peso) {
            retorno = "O " + this.sabor + " tem um peso maior que o " + outro.sabor;
        }
        else if (this.peso < outro.peso) {
            retorno = "O " + this.sabor + " tem um peso menor que o " + outro.sabor;
        }
        else if (this.peso == outro.peso) {
            retorno = "O " + this.sabor + " tem o mesmo peso que o " + outro.sabor;
        }
        System.out.println(retorno);
    }
    public String Comer()
    {
        if (this.qtnde == 0) {
            return null;
        }
        this.qtnde -= 1;
        return("Um " + this.sabor + " foi comido, ainda tem " + this.qtnde);
    }
    public String Add() {
        this.qtnde += 1;
        return("Um " + this.sabor + " foi guardado, agora tem " + this.qtnde);
    }
}