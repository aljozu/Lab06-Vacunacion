package com.alex.lab06AlexL.Persona;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, String>{
    @Query("SELECT s FROM Persona s WHERE s.id = ?1")
    Optional<Persona> findPersonaByID(String id);
}
