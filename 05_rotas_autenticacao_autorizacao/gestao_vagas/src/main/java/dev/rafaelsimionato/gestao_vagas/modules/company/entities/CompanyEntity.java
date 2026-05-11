package dev.rafaelsimionato.gestao_vagas.modules.company.entities;

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
@Entity(name = "company")
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "O campo [name] é obrigatório")
    private String name;

    @Pattern(regexp = "^[^\\s]+$", message = "O campo [username] não deve conter espaços")
    private String username;

    @Email(message = "O campo [email] deve ser um endereço de email válido")
    private String email;

    @Length(min = 7, max = 16, message = "O campo [password] deve conter entre 7 e 16 caracteres")
    private String password;

    private String website;
    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
