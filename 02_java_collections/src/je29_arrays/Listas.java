package je29_arrays;

import java.util.ArrayList;
import java.util.List;

public class Listas {

    public static void main(String[] args) {

        List linguagens = new ArrayList();

        linguagens.add("Java");
        linguagens.add("C#");
        linguagens.add("JavaScript");
        linguagens.add("Go");
        linguagens.add("Java");

        System.out.println("A linguagem na posição 3 é: " + linguagens.get(3));
        System.out.println("A linguagem Java está na posição: " + linguagens.indexOf("Java"));

        linguagens.remove("Go");
        linguagens.add(0, "Python");
        System.out.println("A linguagem Java está na posição: " + linguagens.indexOf("Java"));

        System.out.println("Comprimeiro da lista: " + linguagens.size());

        System.out.println(linguagens.contains("Go"));
        System.out.println(linguagens.contains("Python"));

        for(Object linguagem: linguagens){
            System.out.println(linguagem);
        }

    }

}
