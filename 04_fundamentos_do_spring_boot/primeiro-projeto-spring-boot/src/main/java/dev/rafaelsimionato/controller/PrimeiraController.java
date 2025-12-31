package dev.rafaelsimionato.controller;

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

}
