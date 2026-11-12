package dev.rafaelsimionato.gestao_cursos.modules.course.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UpdateCourseRequestDTO {

    @Schema(example = "Curso de Java")
    @Length(min = 3, max = 255, message = "O campo [name] deve conter entre 3 e 255 caracteres.")
    private String name;

    @Schema(example = "JAVA")
    @Length(min = 3, max = 255, message = "O campo [category] deve conter entre 3 e 50 caracteres.")
    private String category;

    @Schema(example = "Danielle Leão")
    @Length(min = 3, max = 255, message = "O campo [teacher] deve conter entre 3 e 255 caracteres.")
    private String teacher;

}
