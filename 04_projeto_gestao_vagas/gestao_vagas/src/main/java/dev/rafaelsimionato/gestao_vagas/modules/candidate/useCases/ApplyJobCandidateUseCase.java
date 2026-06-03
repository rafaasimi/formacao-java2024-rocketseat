package dev.rafaelsimionato.gestao_vagas.modules.candidate.useCases;

import dev.rafaelsimionato.gestao_vagas.exceptions.JobNotFoundException;
import dev.rafaelsimionato.gestao_vagas.exceptions.UserNotFoundException;
import dev.rafaelsimionato.gestao_vagas.modules.candidate.CandidateRepository;
import dev.rafaelsimionato.gestao_vagas.modules.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApplyJobCandidateUseCase {

    @Autowired
    CandidateRepository candidateRepository;

    @Autowired
    JobRepository jobRepository;

    //    ID do Candidato
    //    ID da Vaga
    public void execute(UUID idCandidate, UUID idJob) {

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

    }

}
