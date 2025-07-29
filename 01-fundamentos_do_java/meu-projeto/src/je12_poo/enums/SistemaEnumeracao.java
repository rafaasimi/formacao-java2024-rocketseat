package je12_poo.enums;

public class SistemaEnumeracao {

    public static void main(String[] args) {

        String nomeEstado = "RIO_GRANDE_DO_SUL";

//        EstadoBrasileiro eb = EstadoBrasileiro.SAO_PAULO;
        EstadoBrasileiro eb = EstadoBrasileiro.valueOf(nomeEstado);
        System.out.println(eb.name());
        System.out.println(eb.getNome());
        System.out.println(eb.getSigla());

        for (EstadoBrasileiro estadoBrasileiro : EstadoBrasileiro.values()) {
            System.out.println(estadoBrasileiro.name() + " - " + estadoBrasileiro.getNome() + " - " + estadoBrasileiro.getSigla());
        }

    }

}
