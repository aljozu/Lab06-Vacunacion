package com.alex.lab06AlexL.Persona;

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
            Persona uno = new Persona("48874885", "Alex", "Jose", LocalDate.of(1999, Month.JULY, 14), "945786154", "al.lo@gmail.com");
            Persona dos = new Persona("48874487", "Gabi", "Mo", LocalDate.of(1995, Month.OCTOBER, 26),"94545854", "ga.mo@gmail.com");
            repository.saveAll(List.of(uno, dos));
        };
    }
}
