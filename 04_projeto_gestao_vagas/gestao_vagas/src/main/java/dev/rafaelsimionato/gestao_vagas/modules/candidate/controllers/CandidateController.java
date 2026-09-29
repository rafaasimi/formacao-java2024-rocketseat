package dev.rafaelsimionato.gestao_vagas.modules.candidate.controllers;

import dev.rafaelsimionato.gestao_vagas.exceptions.UserFoundException;
import dev.rafaelsimionato.gestao_vagas.modules.candidate.entities.CandidateEntity;
import dev.rafaelsimionato.gestao_vagas.modules.candidate.repositories.CandidateRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateRepository candidateRepository;

    @PostMapping("/")
    public ResponseEntity<CandidateEntity> create(@Valid @RequestBody CandidateEntity candidateEntity) {

        candidateRepository
                .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                .ifPresent((candidate) -> {
                    throw new UserFoundException();
                });


        CandidateEntity candidate = candidateRepository.save(candidateEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(candidate);
    }

}
