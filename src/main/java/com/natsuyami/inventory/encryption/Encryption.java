package com.natsuyami.inventory.encryption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encryption {

    private static final Logger LOGGER = LoggerFactory.getLogger(Encryption.class);

    public static BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
