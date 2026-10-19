package dev.rafaelsimionato.gestao_vagas.modules.candidate.useCases;

import dev.rafaelsimionato.gestao_vagas.modules.candidate.dtos.ProfileCandidateResponseDTO;
import dev.rafaelsimionato.gestao_vagas.modules.candidate.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProfileCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    public ProfileCandidateResponseDTO execute(UUID idCandidate) {

        var candidate = candidateRepository
                .findById(idCandidate)
                .orElseThrow(() -> new UsernameNotFoundException("Candidato não encontrado"));

        return ProfileCandidateResponseDTO
                .builder()
                .description(candidate.getDescription())
                .username(candidate.getUsername())
                .email(candidate.getEmail())
                .name(candidate.getName())
                .id(candidate.getId())
                .build();

    }

}
