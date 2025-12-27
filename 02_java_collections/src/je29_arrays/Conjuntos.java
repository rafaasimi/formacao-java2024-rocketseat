package je29_arrays;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Conjuntos {

    public static void main(String[] args) {

//        Set linguagens = new HashSet();
//        Set linguagens = new LinkedHashSet();
        Set linguagens = new TreeSet();

        linguagens.add("Java");
        linguagens.add("C#");
        linguagens.add("Python");
        linguagens.add("JavaScript");
        linguagens.add("Go");
        linguagens.add("Java");

        System.out.println("Comprimeiro da lista: " + linguagens.size());

        System.out.println(linguagens.contains("Go"));
        System.out.println(linguagens.contains("Python"));

        for(Object linguagem: linguagens){
            System.out.println(linguagem);
        }

    }

}
