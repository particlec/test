package com.utyun.smarthome;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableApolloConfig
@SpringBootApplication
public class HomeBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeBackendApplication.class, args);
    }

}
