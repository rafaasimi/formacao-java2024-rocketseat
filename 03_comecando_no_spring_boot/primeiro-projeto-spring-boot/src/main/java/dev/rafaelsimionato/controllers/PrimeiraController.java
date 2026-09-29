package dev.rafaelsimionato.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PrimeiraController {

    @GetMapping()
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<String> buscarUsuario(@PathVariable String id) {
        return ResponseEntity.ok("Dados do usuário: " + id);
    }

// Casos com poucos queryParams
//    @GetMapping("/usuarios")
//    public Object buscarUsuarios(@RequestParam Boolean ativo) {
//        return ResponseEntity.ok("Quero buscar os usuarios ativos?" + ativo);
//    }

    // Casos com diversos queryParams
    @GetMapping("/usuarios")
    public Object buscarUsuarios(@RequestParam Map<String, String> params) {
        return ResponseEntity.ok(params);
    }

    @PostMapping("/usuario/criar")
    public String criarUsuario(@RequestHeader String canal, @RequestBody Usuario usuario) {
        return String.format("Usuário %s com a senha %s criado com sucesso via %s.",  usuario.username(), usuario.password(), canal);
    }

    record Usuario(String username, String password) {}

    @PostMapping("/headers")
    public String recuperarHeaders(@RequestHeader Map<String, String> headers) {
        return "headers: " + headers.entrySet();
    }

    @GetMapping("/metodoResponseEntity")
    public ResponseEntity<String> metodoResponseEntity() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Mensagem de erro.");
    }

}
