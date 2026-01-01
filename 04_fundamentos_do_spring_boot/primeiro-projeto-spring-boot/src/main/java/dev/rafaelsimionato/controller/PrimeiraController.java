package dev.rafaelsimionato.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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

    @PostMapping("/usuarios")
    public Object criarUsuario(@RequestBody @Valid Usuario usuario) {
        return usuario;
    }

    record Usuario(
            @NotBlank(message = "O username é obrigatório.")
            String username,

            @Min(value = 18, message = "A idade mínima é 18 anos.")
            int idade
    ) {};

}
