package dev.rafaelsimionato.gestao_vagas.modules.candidate.dtos;

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

    @Schema(example = "Desenvolvedor Java")
    private String description;

    @Schema(example = "nome_sobrenome")
    private String username;

    @Schema(example = "email@gmail.com")
    private String email;

    @Schema(example = "Nome Sobrenome")
    private String name;

    private UUID id;

}
