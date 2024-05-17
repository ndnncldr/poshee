import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
        Scanner scDouble = new Scanner(System.in);
        Scanner scString = new Scanner(System.in);
        int sair = 1;

        System.out.println("Digite o limite do cartão");
        Cartao cartao = new Cartao(scDouble.nextDouble());

        while (sair != 0) {
            System.out.println("Digite o produto que deseja comprar");
            String produto = scString.nextLine();
            System.out.println("Digite o valor do produto");
            double valor = scDouble.nextDouble();
            boolean adicionadoNoCartao = cartao.adicionarNoCartao(new Compra(produto, valor));

            if (adicionadoNoCartao && cartao.getSaldo() > 0) {
                System.out.println("Adicionado no cartão");
                System.out.println("Digite 0 para finalizar a compra ou 1 para continuar comprando");
                sair = scDouble.nextInt();
            } else if (cartao.getSaldo() == 0) {
                System.out.println("Saldo zerado, finalizando a compra");
                sair = 0;
            } else {
                System.out.println("Saldo insuficiente, finalizando a compra");
                sair = 0;
            }


        }

        System.out.printf("""
                
                ***************************
                
                Saldo disponível: %.2f
                
                ***************************
                
                """, cartao.getSaldo());
        System.out.println("""
                ***************************
                COMPRAS REALIZADAS
                """);
        Collections.sort(cartao.getCompras());
        for (Compra compra : cartao.getCompras()) {
            System.out.println(compra.toString());
        }
        System.out.println(""" 
                
                ***************************
                """);

    }
}