import java.util.ArrayList;
import java.util.List;

public class Cartao {
    private double limite;
    private double saldo;
    private List<Compra> compras;

    public Cartao(double limite) {
        this.limite = limite;
        this.saldo = limite;
        this.compras = new ArrayList<>();
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean adicionarNoCartao(Compra compra) {
        if (this.saldo >= compra.getValor()) {
            this.saldo -= compra.getValor();
            this.compras.add(compra);
            return true;
        } else {
            System.out.println("Saldo insuficiente");
            return false;
        }
    }


}
