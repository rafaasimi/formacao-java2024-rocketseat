package dev.rafaelsimionato.gestao_vagas.modules.candidate.useCases;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import dev.rafaelsimionato.gestao_vagas.modules.candidate.dtos.AuthCandidateRequestDTO;
import dev.rafaelsimionato.gestao_vagas.modules.candidate.dtos.AuthCandidateResponseDTO;
import dev.rafaelsimionato.gestao_vagas.modules.candidate.repositories.CandidateRepository;
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
public class AuthCandidateUseCase {

    @Value("${security.token.secret.candidate}")
    private String secretKey;

    @Value("${security.token.expireInHours}")
    private String expireInHours;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthCandidateResponseDTO execute(AuthCandidateRequestDTO authCandidateDTO) throws AuthenticationException {

        var candidate = candidateRepository.findByUsername(authCandidateDTO.username())
                .orElseThrow(() -> {
                    throw new UsernameNotFoundException("Usuário ou senha incorreta");
                });

        // Verificar se a senha são iguais
        var passwordMatches = passwordEncoder.matches(authCandidateDTO.password(), candidate.getPassword());

        // Se não for igual, retorna erro
        if (!passwordMatches) {
            throw new AuthenticationException();
        }

        // Se for igual -> Gerar o token
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        var expiresIn = Instant.now().plus(Duration.ofHours(Integer.parseInt(expireInHours)));
        var token = JWT.create()
                .withIssuer("gestaovagas")
                .withExpiresAt(expiresIn)
                .withSubject(candidate.getId().toString())
                .withClaim("roles", List.of("candidate"))
                .sign(algorithm);

        return AuthCandidateResponseDTO.builder()
                .access_token(token)
                .expires_in(expiresIn.toEpochMilli())
                .build();
    }

}
