package dev.rafaelsimionato.gestao_vagas.modules.company.useCases;

import dev.rafaelsimionato.gestao_vagas.modules.company.dto.JobResponseDTO;
import dev.rafaelsimionato.gestao_vagas.modules.company.entities.JobEntity;
import dev.rafaelsimionato.gestao_vagas.modules.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateJobUseCase {

    @Autowired
    private JobRepository jobRepository;

    public JobResponseDTO execute(JobEntity jobEntity) {
        var job = this.jobRepository.save(jobEntity);

        return JobResponseDTO.builder()
                .id(job.getId())
                .description(job.getDescription())
                .benefits(job.getBenefits())
                .level(job.getLevel())
                .companyId(job.getCompanyId())
                .createdAt(job.getCreatedAt())
                .build();
    }

}
