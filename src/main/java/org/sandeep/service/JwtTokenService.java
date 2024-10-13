package org.sandeep.service;

import io.smallrye.jwt.build.JwtSignature;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonObjectBuilder;
import lombok.Value;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.sandeep.model.User;

@ApplicationScoped
public class JwtTokenService {
    @Inject
    JwtSignature jwtSignature;

    @ConfigProperty(name = "mp.jwt.verify.issuer")
    private String issuer;

    public String generateToken(User user){
        long currentTimeInSeconds = System.currentTimeMillis()/1000;

        JsonObjectBuilder claimsBuilder = Json.createObjectBuilder()
                .add("sub", user.getUsername())
                .add("groups", Json.createArrayBuilder().add(user.getUserType()).build())
                .add("iat", currentTimeInSeconds)
                .add("exp",currentTimeInSeconds+3600)
                .add("iss", issuer);

        return jwtSignature.sign(claimsBuilder.build().toString());
    }
}
