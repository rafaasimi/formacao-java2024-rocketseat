package dev.rafaelsimionato.gestao_vagas.security;

import dev.rafaelsimionato.gestao_vagas.providers.JWTCandidateProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
public class SecurityCandidateFilter extends OncePerRequestFilter {

    @Autowired
    JWTCandidateProvider jwtCandidateProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        SecurityContextHolder.getContext().setAuthentication(null);
        String header = request.getHeader("Authorization");

        var isCandidateRoute = request.getRequestURI().startsWith("/candidate");
        if (isCandidateRoute) {
            if (header != null) {
                var subjectToken = jwtCandidateProvider.validateToken(header);

                if (subjectToken == null) {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    return;
                }

                request.setAttribute("candidate_id", subjectToken.getSubject());
            }
        }

        filterChain.doFilter(request, response);
    }
}
