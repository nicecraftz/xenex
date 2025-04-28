package it.alessandrocalista.xenex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class XenexApplication {
    public static final String ADMIN_TOKEN = System.getenv("ADMIN_TOKEN");
    
    public static void main(String[] args) {
        SpringApplication.run(XenexApplication.class, args);
    }

}
