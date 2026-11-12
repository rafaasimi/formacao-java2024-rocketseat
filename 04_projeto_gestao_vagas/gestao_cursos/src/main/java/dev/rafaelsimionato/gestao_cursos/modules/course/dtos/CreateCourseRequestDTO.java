package dev.rafaelsimionato.gestao_cursos.modules.course.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class CreateCourseRequestDTO {

    @Schema(example = "React para iniciantes")
    @NotBlank(message = "O campo [name] não pode ser nulo.")
    @Length(min = 3, max = 255, message = "O campo [name] deve conter entre 3 e 255 caracteres.")
    private String name;

    @Schema(example = "REACT")
    @NotBlank(message = "O campo [category] não pode ser nulo.")
    @Length(min = 3, max = 255, message = "O campo [category] deve conter entre 3 e 50 caracteres.")
    private String category;

    @Schema(example = "Mayk Brito")
    @NotBlank(message = "O campo [teacher] não pode ser nulo.")
    @Length(min = 3, max = 255, message = "O campo [teacher] deve conter entre 3 e 255 caracteres.")
    private String teacher;

    private Boolean active;

}
