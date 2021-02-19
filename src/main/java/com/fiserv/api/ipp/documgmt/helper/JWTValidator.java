package com.fiserv.api.ipp.documgmt.helper;

import com.fiserv.api.ipp.documgmt.DocumentsResource;
import com.fiserv.api.ipp.documgmt.exception.UnauthorizedException;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import java.util.Date;

@ApplicationScoped
public class JWTValidator {

    private static Logger logger = LoggerFactory.getLogger(JWTValidator.class);

    @ConfigProperty(name="allowed.subjects")
    String jwtSubject;

    public void validateJWT(JsonWebToken jwt){
        String reasonCode = null;

        String[] subjects = jwtSubject.split(",");
        boolean checked = false;
        for(String subject : subjects){
            if(subject.equals(jwt.getSubject())){
                checked = true;
                break;
            }
        }

        if(!checked){
            reasonCode = "103";
        }

        if(reasonCode != null){
            throw new UnauthorizedException(String.format("The token is not valid: %s.",reasonCode));
        }
        if(new Date().getTime() > jwt.getExpirationTime()){
            throw new UnauthorizedException("The token is not valid: 104.");
        }
    }
}
