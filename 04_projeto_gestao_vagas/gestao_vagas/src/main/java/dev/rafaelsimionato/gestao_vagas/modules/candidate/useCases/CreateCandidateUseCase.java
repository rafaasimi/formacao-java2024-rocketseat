package dev.rafaelsimionato.gestao_vagas.modules.candidate.useCases;

import dev.rafaelsimionato.gestao_vagas.exceptions.UserFoundException;
import dev.rafaelsimionato.gestao_vagas.modules.candidate.entities.CandidateEntity;
import dev.rafaelsimionato.gestao_vagas.modules.candidate.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CandidateEntity execute(CandidateEntity candidateEntity) {

        candidateRepository
                .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                .ifPresent((candidate) -> {
                    throw new UserFoundException();
                });


        var password = passwordEncoder.encode(candidateEntity.getPassword());
        candidateEntity.setPassword(password);

        return candidateRepository.save(candidateEntity);
    }

}
