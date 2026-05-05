package dev.rafaelsimionato.controller;

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
        response.put("status", "OK");
        return response;
    }

    @GetMapping("/users/{id}")
    public String getUserById(@PathVariable String id) {
        return "O usuário selecionado foi o de id: " + id;
    }

    @GetMapping("/users")
    public String getUsers(@RequestParam Map<String, String> params) {
        return "Os queryParams informados são: " + params;
    }

    @PostMapping("/users/create")
    public String createUser(@RequestBody Usuario usuario) {
        return "Usuário criado com sucesso " + usuario.usuario;
    }

//    Recebendo um único header
//    @PostMapping("/users/create/header")
//    public String createUserHeader(@RequestHeader String usuario) {
//        return "Usuário criado com sucesso " + usuario;
//    }

    // Recebendo diversos headers
    @PostMapping("/users/create/header")
    public Object createUserHeader(@RequestHeader Map<String, String> headers) {
        return headers.entrySet();
    }

    record Usuario(String usuario) {
    }

    @GetMapping("/response-entity/{id}")
    public ResponseEntity<Object> metodoResponseEntity(@PathVariable Long id) {

        if (id != 7) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Sem permissão para visualizar os dados desse usuário.");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Usuario " + id + " foi encontrado.");
    }

}
