package org.sandeep.service;

import io.smallrye.jwt.auth.principal.JWTParser;
import io.smallrye.jwt.auth.principal.ParseException;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.sandeep.model.User;

import java.util.Arrays;
import java.util.HashSet;

import static org.sandeep.constants.ApplicationConstants.JWT_CLAIM_TYPE;
import static org.sandeep.constants.ApplicationConstants.REFRESH;

@ApplicationScoped
public class JwtTokenService {

    @Inject
    JWTParser jwtParser;

    @ConfigProperty(name = "mp.jwt.verify.issuer")
    private String issuer;

    public String generateToken(User user) {
        return Jwt.issuer(issuer)
                .subject(user.getUsername())
                .groups(new HashSet<>(Arrays.asList(user.getUserType())))
                .issuedAt(System.currentTimeMillis() / 1000)
                .expiresIn(3600)
                .sign();
    }

    public String generateRefreshToken(User user) {
        return Jwt.issuer(issuer)
                .subject(user.getUsername())
                .expiresIn(2592000)
                .claim(JWT_CLAIM_TYPE, REFRESH)
                .sign();
    }

    public boolean validateRefreshToken(String refreshToken) throws ParseException {
        JsonWebToken jwt = jwtParser.parse(refreshToken);
        return jwt.getClaim(JWT_CLAIM_TYPE).equals(REFRESH);
    }
}
