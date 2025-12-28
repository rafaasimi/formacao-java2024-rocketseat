package je29_arrays;

import java.util.*;

public class Mapas {

    public static void main(String[] args) {

//        Map<String, String> estados = new HashMap<>();
//        Map<String, String> estados = new LinkedHashMap<>();
        Map<String, String> estados = new TreeMap<>();

        estados.put("SP", "Sao Paulo");
        estados.put("RJ", "Rio de Janeiro");
        estados.put("MG", "Minas Gerais");

        Iterator<String> chaves = estados.keySet().iterator();
        while (chaves.hasNext()) {
            String chave = chaves.next();
            String valor = estados.get(chave);
            System.out.println("Chave: " + chave + " | Valor: " + valor);
        }

        System.out.println("O estado de chave SP é: " + estados.get("SP"));

    }

}
