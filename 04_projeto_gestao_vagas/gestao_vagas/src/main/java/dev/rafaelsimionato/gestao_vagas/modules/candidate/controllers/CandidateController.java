package dev.rafaelsimionato.gestao_vagas.modules.candidate.controllers;

import dev.rafaelsimionato.gestao_vagas.modules.candidate.entities.CandidateEntity;
import dev.rafaelsimionato.gestao_vagas.modules.candidate.useCases.CreateCandidateUseCase;
import dev.rafaelsimionato.gestao_vagas.modules.candidate.useCases.ListAllJobsByFilterUseCase;
import dev.rafaelsimionato.gestao_vagas.modules.candidate.useCases.ProfileCandidateUseCase;
import dev.rafaelsimionato.gestao_vagas.modules.company.entities.JobEntity;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CreateCandidateUseCase createCandidateUseCase;

    @Autowired
    private ProfileCandidateUseCase profileCandidateUseCase;

    @Autowired
    private ListAllJobsByFilterUseCase listAllJobsByFilterUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity) {
        try {
            var result = createCandidateUseCase.execute(candidateEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('CANDIDATE')")
    public ResponseEntity<Object> get(HttpServletRequest request) {
        var candidateId = request.getAttribute("candidate_id");

        try {
            var profile = profileCandidateUseCase.execute(UUID.fromString(candidateId.toString()));
            return ResponseEntity.ok().body(profile);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/jobs")
    @PreAuthorize("hasRole('CANDIDATE')")
    public List<JobEntity> findJobByFilter(@RequestParam String filtter) {
        return listAllJobsByFilterUseCase.execute(filtter);
    }
}
