package com.cognizant.springlearn.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Issues a signed JWT to authenticated users.
 *
 * The client sends Basic Auth credentials (username + password encoded
 * in Base64) to GET /authenticate. This controller:
 *   1. Reads the Authorization header (Basic scheme).
 *   2. Decodes Base64 to extract the plain-text username.
 *   3. Builds a JWT with the username as the subject, valid for 20 minutes.
 *   4. Returns {"token": "<jwt-value>"} as a JSON response.
 *
 * The client then uses the token in the Authorization header of every
 * subsequent request using the Bearer scheme.
 */
@RestController
public class AuthenticationController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(AuthenticationController.class);

    /** Must match the signing key used in JwtAuthorizationFilter */
    private static final String JWT_SECRET = "cognizant-secret-key-2024";

    /** Token validity window: 20 minutes expressed in milliseconds */
    private static final long EXPIRY_MS = 20 * 60 * 1000L;

    @GetMapping("/authenticate")
    public Map<String, String> issueToken(
            @RequestHeader("Authorization") String authHeader) {

        LOGGER.info("START");
        LOGGER.debug("Received auth header -> {}", authHeader);

        String username = decodeUsername(authHeader);
        String token    = buildToken(username);

        Map<String, String> payload = new HashMap<>();
        payload.put("token", token);

        LOGGER.info("END — token issued for user -> {}", username);
        return payload;
    }

    /**
     * Strips the "Basic " prefix, Base64-decodes the remainder,
     * and returns only the username portion (before the colon).
     */
    private String decodeUsername(String authHeader) {
        LOGGER.debug("Decoding credentials from header");
        String encoded   = authHeader.substring("Basic ".length());
        String decoded   = new String(Base64.getDecoder().decode(encoded));
        String username  = decoded.substring(0, decoded.indexOf(':'));
        LOGGER.debug("Extracted username -> {}", username);
        return username;
    }

    /**
     * Constructs a compact, signed JWT.
     * Payload claims:
     *   sub  -> username
     *   iat  -> issued-at timestamp
     *   exp  -> expiry timestamp (iat + 20 minutes)
     */
    private String buildToken(String username) {
        Date now    = new Date();
        Date expiry = new Date(now.getTime() + EXPIRY_MS);

        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(SignatureAlgorithm.HS256, JWT_SECRET)
                .compact();

        LOGGER.debug("Token built, expires at -> {}", expiry);
        return token;
    }
}
