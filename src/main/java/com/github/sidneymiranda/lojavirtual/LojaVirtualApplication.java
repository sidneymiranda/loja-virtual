package com.github.sidneymiranda.lojavirtual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "com.github.sidneymiranda.lojavirtual.model")
@SpringBootApplication
public class LojaVirtualApplication {

    public static void main(String[] args) {
        SpringApplication.run(LojaVirtualApplication.class, args);
    }

}
