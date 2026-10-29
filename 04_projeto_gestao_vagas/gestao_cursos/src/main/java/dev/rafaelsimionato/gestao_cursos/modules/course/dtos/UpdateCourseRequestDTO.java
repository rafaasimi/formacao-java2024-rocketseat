package dev.rafaelsimionato.gestao_cursos.modules.course.dtos;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UpdateCourseRequestDTO {

    @Length(min = 3, max = 255, message = "O campo [name] deve conter entre 3 e 255 caracteres.")
    private String name;

    @Length(min = 3, max = 255, message = "O campo [category] deve conter entre 3 e 50 caracteres.")
    private String category;

    @Length(min = 3, max = 255, message = "O campo [teacher] deve conter entre 3 e 255 caracteres.")
    private String teacher;

}
