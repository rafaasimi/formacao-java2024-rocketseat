package dev.rafaelsimionato.ioc_di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meu-component")
public class MeuComponentController {

    @Autowired
    MeuComponent meuComponent;

    // Maneira errada de gerenciar componente
//    @GetMapping("/")
//    public String chamandoComponent() {
//        var meuComponent = new MeuComponent();
//        var resultado = meuComponent.chamarMeuComponent();
//        return resultado;
//    }

    @GetMapping("/")
    public String chamandoComponent() {
        var resultado = meuComponent.chamarMeuComponent();
        return resultado;
    }

}
