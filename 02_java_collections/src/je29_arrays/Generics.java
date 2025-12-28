package je29_arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Generics {

    public static void main(String[] args) {

        // String - Brinquedos
        // Integer - CDs
        // Boolean - Livros

//        List prateleira = new ArrayList();
        List<String> prateleira = new ArrayList<>();
        prateleira.add("Carrinho 1");
        prateleira.add("Carrinho 2");
        prateleira.add("Tiggo 5X");
        prateleira.add("Jeep");
        prateleira.add("Gol");
        prateleira.add("HB20");

        Collections.sort(prateleira);
        Collections.shuffle(prateleira);

        // Utilizando Generics, eu asseguro que só vou adicionar Strings na prateleira
//        prateleira.add(1);
//        prateleira.add(2);
//        prateleira.add(3);
//        prateleira.add(true);
//        prateleira.add(false);

        for (String carrinho : prateleira) {
            System.out.println(carrinho);
        }

    }

}
