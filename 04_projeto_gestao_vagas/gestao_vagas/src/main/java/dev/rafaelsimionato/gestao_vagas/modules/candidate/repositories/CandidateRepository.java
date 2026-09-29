package dev.rafaelsimionato.gestao_vagas.modules.candidate.repositories;


import dev.rafaelsimionato.gestao_vagas.modules.candidate.entities.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {}
