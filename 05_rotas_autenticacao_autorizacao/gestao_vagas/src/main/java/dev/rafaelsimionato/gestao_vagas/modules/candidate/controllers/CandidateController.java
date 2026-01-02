package dev.rafaelsimionato.gestao_vagas.modules.candidate.controllers;

import dev.rafaelsimionato.gestao_vagas.modules.candidate.CandidateEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @PostMapping("/novo")
    public void create(@RequestBody CandidateEntity candidate) {
        System.out.println("Candidato: " + candidate.getName() + " criado com sucesso!");
    }

}
