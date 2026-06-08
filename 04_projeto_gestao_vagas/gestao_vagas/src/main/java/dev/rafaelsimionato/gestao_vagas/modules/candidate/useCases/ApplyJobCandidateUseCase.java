package dev.rafaelsimionato.gestao_vagas.modules.candidate.useCases;

import dev.rafaelsimionato.gestao_vagas.exceptions.JobNotFoundException;
import dev.rafaelsimionato.gestao_vagas.exceptions.UserNotFoundException;
import dev.rafaelsimionato.gestao_vagas.modules.candidate.CandidateRepository;
import dev.rafaelsimionato.gestao_vagas.modules.candidate.entities.ApplyJobEntity;
import dev.rafaelsimionato.gestao_vagas.modules.candidate.repositories.ApplyJobRepository;
import dev.rafaelsimionato.gestao_vagas.modules.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApplyJobCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplyJobRepository applyJobRepository;

    //    ID do Candidato
    //    ID da Vaga
    public ApplyJobEntity execute(UUID idCandidate, UUID idJob) {

        //    Validar se o candidato existe
        var candidate = this.candidateRepository.findById(idCandidate)
                .orElseThrow(() -> {
                    throw new UserNotFoundException();
                });

        //    Validar se a vaga existe
        var job = this.jobRepository.findById(idJob)
                .orElseThrow(() -> {
                    throw new JobNotFoundException();
                });

        //    Candidato se inscrever na vaga
        var applyJob = ApplyJobEntity.builder()
                .candidateId(idCandidate)
                .jobId(idJob)
                .build();

        return this.applyJobRepository.save(applyJob);
    }

}
