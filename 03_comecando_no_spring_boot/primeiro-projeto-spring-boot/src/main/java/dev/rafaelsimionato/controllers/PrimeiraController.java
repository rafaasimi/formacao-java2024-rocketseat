package dev.rafaelsimionato.controllers;

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

}
