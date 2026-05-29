package dev.rafaelsimionato.gestao_vagas.modules.candidate.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileCandidateResponseDTO {

    private UUID id;

    @Schema(example = "Desenvolvedor Fullstack com foco em front-end")
    private String description;

    @Schema(example = "rafael")
    private String username;

    @Schema(example = "rafael@gmail.com")
    private String email;

    @Schema(example = "Rafael Simionato")
    private String name;

}
