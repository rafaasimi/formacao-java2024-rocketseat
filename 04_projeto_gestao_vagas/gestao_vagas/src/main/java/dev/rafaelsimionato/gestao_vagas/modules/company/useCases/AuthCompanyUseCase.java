package dev.rafaelsimionato.gestao_vagas.modules.company.useCases;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import dev.rafaelsimionato.gestao_vagas.enums.RolesEnum;
import dev.rafaelsimionato.gestao_vagas.modules.company.dtos.AuthCompanyRequestDTO;
import dev.rafaelsimionato.gestao_vagas.modules.company.dtos.AuthCompanyResponseDTO;
import dev.rafaelsimionato.gestao_vagas.modules.company.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

@Service
public class AuthCompanyUseCase {

    @Value("${security.token.secret.company}")
    private String secretKey;

    @Value("${security.token.expireInHours}")
    private String expireInHours;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthCompanyResponseDTO execute(AuthCompanyRequestDTO authCompanyRequestDTO) throws AuthenticationException {
        var company = companyRepository.findByUsername(authCompanyRequestDTO.getUsername()).orElseThrow(() -> {
            throw new UsernameNotFoundException("Usuário ou senha incorreta");
        });

        // Verificar se a senha são iguais
        var passwordMatches = this.passwordEncoder.matches(authCompanyRequestDTO.getPassword(), company.getPassword());

        // Se não for igual, retorna erro
        if (!passwordMatches) {
            throw new AuthenticationException();
        }

        // Se for igual -> Gerar o token
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        var expiresIn = Instant.now().plus(Duration.ofHours(Integer.parseInt(expireInHours)));

        var token = JWT.create().withIssuer("gestaovagas")
                .withExpiresAt(expiresIn)
                .withSubject(company.getId().toString())
                .withClaim("roles", List.of(RolesEnum.COMPANY.toString()))
                .sign(algorithm);

        return AuthCompanyResponseDTO.builder()
                .expires_in(expiresIn.toEpochMilli())
                .access_token(token)
                .build();
    }

}
