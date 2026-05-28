package dev.rafaelsimionato.gestao_vagas.modules.candidate.useCases;

import dev.rafaelsimionato.gestao_vagas.modules.company.dto.JobResponseDTO;
import dev.rafaelsimionato.gestao_vagas.modules.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllJobsByFilterUseCase {

    @Autowired
    private JobRepository jobRepository;

    public List<JobResponseDTO> execute(String filter) {
        return this.jobRepository.findByDescriptionContainingIgnoreCase(filter)
                .stream()
                .map(job -> {
                    return JobResponseDTO.builder()
                            .id(job.getId())
                            .description(job.getDescription())
                            .benefits(job.getBenefits())
                            .level(job.getLevel())
                            .companyId(job.getCompanyId())
                            .createdAt(job.getCreatedAt())
                            .build();
                })
                .toList();
    }

}
