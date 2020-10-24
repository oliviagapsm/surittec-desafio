package com.surittec.desafio.config;


import com.surittec.desafio.config.db.DBInitialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;


@Configuration
@Profile("dev")
public class DevConfig {

    @Autowired
    private DBInitialize dbInitialize;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Bean
    public boolean intastianteDatabase() throws ParseException {

        if(!"create".equals(strategy)) {
            return false;
        }

        dbInitialize.instantieateTestDatabase();
        return true;
    }

}