package dev.rafaelsimionato.gestao_vagas.modules.candidate.useCases;

import dev.rafaelsimionato.gestao_vagas.exceptions.UserNotFoundException;
import dev.rafaelsimionato.gestao_vagas.modules.candidate.CandidateRepository;
import dev.rafaelsimionato.gestao_vagas.modules.company.repositories.JobRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ApplyJobCandidateUseCaseTest {

    @InjectMocks
    ApplyJobCandidateUseCase applyJobCandidateUseCase;

    @Mock
    CandidateRepository candidateRepository;

    @Mock
    JobRepository jobRepository;

    @Test
    @DisplayName("Não deve ser possível aplicar a uma vaga se não existir candidato ")
    public void shouldNotBeAbleToApplyWithCandidateNotFoud() {
        try {
            this.applyJobCandidateUseCase.execute(null, null);
        } catch (Exception ex) {
            assertThat(ex).isInstanceOf(UserNotFoundException.class);
        }
    }

}
