package com.cognizant.springlearn.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

/**
 * Servlet filter that intercepts every incoming HTTP request and checks
 * whether a valid JWT is present in the Authorization header.
 *
 * Processing logic:
 *  1. Read the Authorization header value.
 *  2. If it does not start with "Bearer ", skip JWT validation and
 *     let the request proceed (Basic Auth handles /authenticate).
 *  3. If it starts with "Bearer ", parse and verify the token signature
 *     using the shared secret key.
 *  4. On success, create a UsernamePasswordAuthenticationToken and
 *     register it with SecurityContextHolder so that Spring Security
 *     considers the current request authenticated.
 *  5. On failure (expired / tampered token), return without setting
 *     authentication — Spring Security will respond with 401/403.
 */
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(JwtAuthorizationFilter.class);

    private static final String JWT_SECRET = "cognizant-secret-key-2024";
    private static final String BEARER_PREFIX = "Bearer ";

    public JwtAuthorizationFilter(AuthenticationManager manager) {
        super(manager);
        LOGGER.info("JwtAuthorizationFilter initialised");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws IOException, ServletException {

        LOGGER.info("START doFilterInternal");
        String header = request.getHeader("Authorization");
        LOGGER.debug("Authorization header value -> {}", header);

        if (header == null || !header.startsWith(BEARER_PREFIX)) {
            LOGGER.debug("No Bearer token present — passing request to next filter");
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authToken = validateToken(header);
        SecurityContextHolder.getContext().setAuthentication(authToken);
        chain.doFilter(request, response);
        LOGGER.info("END doFilterInternal");
    }

    /**
     * Parses the JWT, verifies the signature, and extracts the subject (username).
     * Returns null if the token is invalid or expired.
     */
    private UsernamePasswordAuthenticationToken validateToken(String authHeader) {
        String rawToken = authHeader.replace(BEARER_PREFIX, "");
        try {
            Jws<Claims> parsed = Jwts.parser()
                    .setSigningKey(JWT_SECRET)
                    .parseClaimsJws(rawToken);

            String username = parsed.getBody().getSubject();
            LOGGER.debug("Token valid for user -> {}", username);

            if (username != null) {
                return new UsernamePasswordAuthenticationToken(
                        username, null, Collections.emptyList());
            }
        } catch (JwtException ex) {
            LOGGER.warn("JWT validation failed -> {}", ex.getMessage());
        }
        return null;
    }
}
