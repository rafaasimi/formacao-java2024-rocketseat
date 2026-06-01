package dev.rafaelsimionato.cursos_programacao.modules.courses;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "course")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Schema(example = "Curso de Java", requiredMode = Schema.RequiredMode.REQUIRED, description = "Nome do curso")
    private String name;

    @Schema(example = "back-end", requiredMode = Schema.RequiredMode.REQUIRED, description = "Categoria do curso")
    private String category;

    @Schema(example = "John Doe", description = "Nome do professor")
    private String teacher;

    private boolean active;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;


}
