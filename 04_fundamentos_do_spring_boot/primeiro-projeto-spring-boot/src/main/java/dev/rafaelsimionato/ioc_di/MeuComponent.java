package dev.rafaelsimionato.ioc_di;

import org.springframework.stereotype.Component;

@Component
public class MeuComponent {

    public String chamarMeuComponente() {
        return "Chamando meu component!";
    }

}
