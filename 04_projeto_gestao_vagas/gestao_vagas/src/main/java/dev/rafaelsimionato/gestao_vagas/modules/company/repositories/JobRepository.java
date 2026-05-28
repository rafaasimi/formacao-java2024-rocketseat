package dev.rafaelsimionato.gestao_vagas.modules.company.repositories;

import dev.rafaelsimionato.gestao_vagas.modules.company.entities.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {

    // contains - LIKE
    // Select * from job where description like %filter%
    List<JobEntity> findByDescriptionContainingIgnoreCase(String description);

}
