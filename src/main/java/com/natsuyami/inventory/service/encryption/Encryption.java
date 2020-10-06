package com.natsuyami.inventory.service.encryption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Service
public class Encryption {

    private static final Logger LOGGER = LoggerFactory.getLogger(Encryption.class);

    // cannot  inject when async method
    // cause it might call the method uses this before the controller can be able to pass the header
    @Autowired
    private HttpServletRequest httpRequest;


    public String encoder(String secret) {
        BCryptPasswordEncoder encrypt = new BCryptPasswordEncoder();
        return encrypt.encode(secret);
    }

    public String jwtConverter() {
        LOGGER.info("Initialized jwtConverter method from Encryption class");
        Principal principal = httpRequest.getUserPrincipal();
        LOGGER.info("Decryption of the token produces");
        return principal.getName();
    }
}
