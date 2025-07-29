package je12_poo;

public class Sistema {

    public static void main(String[] args) {

        Cliente rafael = new Cliente("Rafael Simionato");
        System.out.println("Limite do(a): " + rafael.nome + " é de " + rafael.limiteCredito);
        rafael.solicitarLimiteCredito(200.0);
        System.out.println("Limite do(a): " + rafael.nome + " é de " + rafael.limiteCredito);

        Cliente patricia = new Cliente("Patricia Gomes");
        System.out.println("Limite do(a): " + patricia.nome + " é de " + patricia.limiteCredito);
        patricia.solicitarLimiteCredito(80.0);
        patricia.comprar(50.0);
        System.out.println("Limite do(a): " + patricia.nome + " é de " + patricia.limiteCredito);

    }

}
