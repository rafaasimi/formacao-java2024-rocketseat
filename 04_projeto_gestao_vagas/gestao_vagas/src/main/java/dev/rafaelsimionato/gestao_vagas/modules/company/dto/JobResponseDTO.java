package dev.rafaelsimionato.gestao_vagas.modules.company.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class JobResponseDTO {

    private UUID id;

    @Schema(example = "Vaga para Desenvolvedor Java")
    private String description;

    @Schema(example = "Vale transporte, plano de saúde")
    private String benefits;

    @Schema(example = "Pleno")
    private String level;

    private UUID companyId;

    private LocalDateTime createdAt;

}
