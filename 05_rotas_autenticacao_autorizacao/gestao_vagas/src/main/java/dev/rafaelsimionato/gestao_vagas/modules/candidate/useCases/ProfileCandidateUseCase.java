package dev.rafaelsimionato.gestao_vagas.modules.candidate.useCases;

import dev.rafaelsimionato.gestao_vagas.modules.candidate.CandidateRepository;
import dev.rafaelsimionato.gestao_vagas.modules.candidate.dto.ProfileCandidateResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProfileCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    public ProfileCandidateResponseDTO execute(UUID idCandidate) {
        var candidate = this.candidateRepository.findById(idCandidate)
                .orElseThrow(() -> {
                    throw new UsernameNotFoundException("Candidato não encontrado");
                });

        return ProfileCandidateResponseDTO.builder()
                .id(candidate.getId())
                .name(candidate.getName())
                .email(candidate.getEmail())
                .username(candidate.getUsername())
                .description(candidate.getDescription())
                .build();

    }

}
