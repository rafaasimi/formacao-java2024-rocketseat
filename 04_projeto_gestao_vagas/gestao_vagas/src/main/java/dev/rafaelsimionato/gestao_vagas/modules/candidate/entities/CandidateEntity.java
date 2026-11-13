package dev.rafaelsimionato.gestao_vagas.modules.candidate.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "candidate")
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Schema(example = "Rafael Simionato", description = "Nome do candidato")
    private String name;

    @Schema(example = "rafael_simionato", description = "Username do candidato")
    @Pattern(regexp = "^[^\\s]+$", message = "O campo [username] não deve conter espaços")
    private String username;

    @Email(message = "O campo [email] deve conter um e-mail válido")
    @Schema(example = "rafael.simionato@example.com", description = "E-mail do candidato")
    private String email;

    @Schema(example = "admin@123", minLength = 7, maxLength = 255, requiredMode = Schema.RequiredMode.REQUIRED, description = "Senha do candidato")
    @Length(min = 7, max = 255, message = "O campo [password] deve conter entre 7 e 255 caracteres")
    private String password;

    @Schema(example = "Desenvolvedor web", description = "Descrição do candidato")
    private String description;
    private String curriculum;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
