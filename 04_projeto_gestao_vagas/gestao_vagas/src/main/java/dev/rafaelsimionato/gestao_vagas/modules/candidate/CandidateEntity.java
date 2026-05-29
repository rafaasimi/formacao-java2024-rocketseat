package dev.rafaelsimionato.gestao_vagas.modules.candidate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "candidate")
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Schema(example = "Rafael Simionato", requiredMode = Schema.RequiredMode.REQUIRED, description = "Nome do candidato")
    @NotBlank(message = "O campo [name] é obrigatório")
    private String name;

    @Schema(example = "rafael", requiredMode = Schema.RequiredMode.REQUIRED, description = "Username do candidato")
    @Pattern(regexp = "^[^\\s]+$", message = "O campo [username] não deve conter espaços")
    private String username;

    @Schema(example = "rafael@gmail.com", requiredMode = Schema.RequiredMode.REQUIRED, description = "E-mail do candidato")
    @Email(message = "O campo [email] deve ser um endereço de email válido")
    private String email;

    @Schema(example = "1234567", minLength = 7, maxLength = 16, requiredMode = Schema.RequiredMode.REQUIRED, description = "Senha do candidato")
    @Length(min = 7, max = 255, message = "O campo [password] deve conter entre 7 e 255 caracteres")
    private String password;

    @Schema(example = "Desenvolvedor Fullstack com foco em front-end", requiredMode = Schema.RequiredMode.REQUIRED, description = "Breve descrição do candidato")
    private String description;
    private String curriculum;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
