package dev.rafaelsimionato.cursos_programacao.modules.courses.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CreateCourseRequestDTO {

    @Schema(example = "Curso de Java", requiredMode = Schema.RequiredMode.REQUIRED, description = "Nome do curso")
    private String name;

    @Schema(example = "back-end", requiredMode = Schema.RequiredMode.REQUIRED, description = "Categoria do curso")
    private String category;

    @Schema(example = "John Doe", description = "Nome do professor")
    private String teacher;

    @Schema(example = "true", description = "Indica que o curso está ativo ou inativo")
    private boolean active;

}
