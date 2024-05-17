public class Compra implements Comparable<Compra> {
    private String nome;
    private double valor;

    public Compra(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return  nome + " - " + valor;

    }

    @Override
    public int compareTo(Compra o) {
        return Double.compare(this.getValor(), o.getValor());
    }
}
