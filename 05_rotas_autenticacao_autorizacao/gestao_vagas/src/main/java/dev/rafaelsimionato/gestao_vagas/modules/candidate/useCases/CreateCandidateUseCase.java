package dev.rafaelsimionato.gestao_vagas.modules.candidate.useCases;

import dev.rafaelsimionato.gestao_vagas.exceptions.UserFoundException;
import dev.rafaelsimionato.gestao_vagas.modules.candidate.CandidateEntity;
import dev.rafaelsimionato.gestao_vagas.modules.candidate.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.candidateRepository
                .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                .ifPresent(((candidate) -> {
                    throw new UserFoundException();
                }));


        return this.candidateRepository.save(candidateEntity);
    }

}
