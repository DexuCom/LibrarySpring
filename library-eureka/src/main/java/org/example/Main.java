package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Application main class. Required to enable Eureka server. Configuration in application properties.
 */
@SpringBootApplication
@EnableEurekaServer
public class Main {

    /**
     * Application entry point.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
