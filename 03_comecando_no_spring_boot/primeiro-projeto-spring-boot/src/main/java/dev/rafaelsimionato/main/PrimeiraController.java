package dev.rafaelsimionato.main;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PrimeiraController {

    @GetMapping()
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("OK");
    }

}
