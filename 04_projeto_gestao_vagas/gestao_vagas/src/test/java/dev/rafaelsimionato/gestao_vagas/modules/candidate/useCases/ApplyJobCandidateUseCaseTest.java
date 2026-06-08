package dev.rafaelsimionato.gestao_vagas.modules.candidate.useCases;

import dev.rafaelsimionato.gestao_vagas.exceptions.JobNotFoundException;
import dev.rafaelsimionato.gestao_vagas.exceptions.UserNotFoundException;
import dev.rafaelsimionato.gestao_vagas.modules.candidate.CandidateEntity;
import dev.rafaelsimionato.gestao_vagas.modules.candidate.CandidateRepository;
import dev.rafaelsimionato.gestao_vagas.modules.candidate.entities.ApplyJobEntity;
import dev.rafaelsimionato.gestao_vagas.modules.candidate.repositories.ApplyJobRepository;
import dev.rafaelsimionato.gestao_vagas.modules.company.entities.JobEntity;
import dev.rafaelsimionato.gestao_vagas.modules.company.repositories.JobRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ApplyJobCandidateUseCaseTest {

    @InjectMocks
    ApplyJobCandidateUseCase applyJobCandidateUseCase;

    @Mock
    CandidateRepository candidateRepository;

    @Mock
    JobRepository jobRepository;

    @Mock
    ApplyJobRepository applyJobRepository;

    @Test
    @DisplayName("Não deve ser possível aplicar a uma vaga se não existir candidato ")
    public void shouldNotBeAbleToApplyWithCandidateNotFoud() {
        try {
            this.applyJobCandidateUseCase.execute(null, null);
        } catch (Exception ex) {
            assertThat(ex).isInstanceOf(UserNotFoundException.class);
        }
    }

    @Test
    @DisplayName("Não deve ser possivel aplicar em uma vaga que não existe")
    public void shouldNotBeAbleToApplyJobWithJobNotFound() {
        var idCandidate = UUID.randomUUID();
        var candidate = new CandidateEntity();
        candidate.setId(idCandidate);

        when(this.candidateRepository.findById(idCandidate))
                .thenReturn(Optional.of(candidate));

        try {
            this.applyJobCandidateUseCase.execute(idCandidate, null);
        } catch (Exception ex) {
            assertThat(ex).isInstanceOf(JobNotFoundException.class);
        }
    }

    @Test
    @DisplayName("Deve ser possível aplicar em uma vaga")
    public void shouldBeAbleToCreateANewApplyJob() {
        var idCandidate = UUID.randomUUID();
        var idJob = UUID.randomUUID();

        var applyJob = ApplyJobEntity.builder()
                .candidateId(idCandidate)
                .jobId(idJob)
                .build();

        var applyJobCreated = ApplyJobEntity.builder()
                .id(UUID.randomUUID())
                .build();

        when(this.candidateRepository.findById(idCandidate))
                .thenReturn(Optional.of(new CandidateEntity()));

        when(this.jobRepository.findById(idJob))
                .thenReturn(Optional.of(new JobEntity()));

        when(this.applyJobRepository.save(applyJob))
                .thenReturn(applyJobCreated);

        var result = this.applyJobCandidateUseCase.execute(idCandidate, idJob);
        assertThat(result).hasFieldOrProperty("id");
        assertNotNull(result.getId());
    }


}
