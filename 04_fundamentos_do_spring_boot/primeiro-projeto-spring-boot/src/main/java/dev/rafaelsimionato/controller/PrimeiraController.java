package dev.rafaelsimionato.controller;

import dev.rafaelsimionato.ioc_di.MeuComponent;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PrimeiraController {

    @GetMapping("/health")
    public Object health() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");
        return response;
    }

    @GetMapping("/usuario/{id}")
//    public String getUserById(@PathVariable(name = "id") String idUser) {
    public String getUserById(@PathVariable String id) {
        return "O parâmetro id é: " + id;
    }

//    http://localhost:8080/api/usuarios?active=true
//    @GetMapping("/usuarios")
//    public String getUsers(@RequestParam String active) {
//        return "O parâmetro queryParam é: " + active;
//    }

    //    http://localhost:8080/api/usuarios?active=true?role=admin
    @GetMapping("/usuarios")
    public String getUsers(@RequestParam Map<String, String> params) {
        return "Os parâmetros do queryParam são: " + params.entrySet();
    }

    @PostMapping("/usuarios/body")
    public Object criarUsuario(@RequestBody @Valid Usuario usuario) {
        return usuario;
    }

    record Usuario(
            @NotBlank(message = "O username é obrigatório.")
            String username,

            @Min(value = 18, message = "A idade mínima é 18 anos.")
            int idade
    ) {
    }

    ;

//    @PostMapping("/usuarios/header")
//    public Object criarUsuario(@RequestHeader("name") String name) {
//        return name;
//    };

    @PostMapping("/usuarios/header")
    public Object criarUsuario(@RequestHeader Map<String, String> headers) {
        return headers.entrySet();
    }

    ;

    @GetMapping("/response-entity/{id}")
    public ResponseEntity<Object> responseEntity(@PathVariable Long id) {
        var usuario = new Usuario("rafaasimi", 29);

        if (id > 5) {
            return ResponseEntity.status(HttpStatus.OK).body(usuario);
        }

        return ResponseEntity.badRequest().body("Número menor que 5");
    }

    @GetMapping("/")
    public String chamandoComponent() {
        var meuComponent = new MeuComponent();
        return meuComponent.chamarMeuComponente();
    }

}
