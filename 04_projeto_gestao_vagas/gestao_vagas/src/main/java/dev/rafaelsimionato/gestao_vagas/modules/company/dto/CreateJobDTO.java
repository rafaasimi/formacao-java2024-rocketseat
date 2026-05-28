package dev.rafaelsimionato.gestao_vagas.modules.company.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CreateJobDTO {

    @Schema(example = "Vaga para Desenvolvedor Java", requiredMode = Schema.RequiredMode.REQUIRED)
    private String description;

    @Schema(example = "Vale transporte, plano de saúde", requiredMode = Schema.RequiredMode.REQUIRED)
    private String benefits;

    @Schema(example = "Pleno", requiredMode = Schema.RequiredMode.REQUIRED)
    private String level;

}
