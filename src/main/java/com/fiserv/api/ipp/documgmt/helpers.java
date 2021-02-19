package com.fiserv.api.ipp.documgmt;

import io.smallrye.jwt.KeyUtils;
import io.smallrye.jwt.build.Jwt;
import io.smallrye.jwt.build.JwtClaimsBuilder;

import javax.json.Json;
import javax.json.JsonObject;
import java.security.PrivateKey;
import java.security.PublicKey;

public class helpers {
    public static void main(String[] args) throws Exception {
        JsonObject topMid = Json.createObjectBuilder().add("topMid", "").build();
        JsonObject json = Json.createObjectBuilder(topMid).build();
        JwtClaimsBuilder builder = Jwt.claims(json);

        builder.audience("DocumentsManagementxAPI");
        builder.issuer("Portal");
        builder.expiresAt(1606750751000l);
        builder.subject("Portal");
        builder.groups("Admin");

        String jwt = builder.sign(getPrivateKey());

        System.out.println("JWT --->" +jwt);
    }

    private static PrivateKey getPrivateKey() throws Exception {
        return KeyUtils.readPrivateKey("/privateKey.pem");
    }

    private static PublicKey getPublicKey() throws Exception {
        return KeyUtils.readPublicKey("/publicKey.pem");
    }
}
