package com.alex.lab06alexl.persona;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonaConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(PersonaRepository repository){
        return args -> {
            var uno = new Persona("48874885", "Alex", "Jose", LocalDate.of(1999, Month.JULY, 14), "945786154", "al.lo@gmail.com");
            var dos = new Persona("48874487", "Gabi", "Mo", LocalDate.of(1995, Month.OCTOBER, 26),"94545854", "ga.mo@gmail.com");
            repository.saveAll(List.of(uno, dos));
        };
    }
}
