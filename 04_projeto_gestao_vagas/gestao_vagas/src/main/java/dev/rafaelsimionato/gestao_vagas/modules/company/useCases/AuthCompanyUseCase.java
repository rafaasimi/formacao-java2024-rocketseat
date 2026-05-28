package dev.rafaelsimionato.gestao_vagas.modules.company.useCases;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import dev.rafaelsimionato.gestao_vagas.enums.RolesEnum;
import dev.rafaelsimionato.gestao_vagas.modules.company.dto.AuthCompanyDTO;
import dev.rafaelsimionato.gestao_vagas.modules.company.dto.AuthCompanyResponseDTO;
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

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthCompanyResponseDTO execute(AuthCompanyDTO authCompanyDTO) throws AuthenticationException {

        var company = this.companyRepository.findByUsername(authCompanyDTO.getUsername())
                .orElseThrow(() -> {
                    throw new UsernameNotFoundException("Usuário ou senha incorretos");
                });

        // Verificar a senha são iguais
        var passwordMatches = this.passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());

        // Se não for igual -> Erro
        if (!passwordMatches) {
            throw new AuthenticationException();
        }

        // Se for igual -> Gerar token
        Algorithm algorithm = Algorithm.HMAC256(secretKey); // Algoritimo utilizado para assinatura
        var expiresIn = Instant.now().plus(Duration.ofMinutes(30));

        var token = JWT.create().withIssuer("gestao-vagas") // Quem emitiu o token
                .withExpiresAt(expiresIn) // Tempo de expiração do token
                .withSubject(company.getId().toString()) // O ID do usuario
                .withClaim("roles", List.of(RolesEnum.COMPANY.toString()))
                .sign(algorithm); // Assina digitalmente

        var authCompanyResponse = AuthCompanyResponseDTO.builder()
                .access_token(token)
                .expires_in(expiresIn.toEpochMilli())
                .build();

        return authCompanyResponse;
    }

}
