package com.alex.lab06AlexL.Persona;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import com.mashape.unirest.http.Unirest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaService {
    static final Logger logger = Logger.getLogger(PersonaService.class.getName());
    private final PersonaRepository personaRepository;

    @Autowired
    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> getPersonas() {
        return personaRepository.findAll();
    }

    public Persona findOneById(String dni) {
        Optional<Persona> personaOptional = personaRepository.findById(dni);
        if (personaOptional.isPresent())
            return personaOptional.get();
        else
            throw new RuntimeException("El usuario con el dni " + dni + " no existe!");
    }

    private Boolean existe(Persona persona) throws Exception {
        String url = "http://ws-consultas.herokuapp.com/api/dni/" + persona.getId();

        int code = Unirest.get(url).asString().getStatus();
        if (code != 200) {
            return false;
        } else {
            var jsonResponse = Unirest.get(url).queryString("nombres", "nombre").queryString("apellido_p", "apellidop")
                    .queryString("apellido_m", "apellidom").asJson();
            var jsonContent = jsonResponse.getBody().toString();
            var obj = new JSONObject(jsonContent);
            var name1 = persona.getApellidos() + " " + persona.getNombres();
            var name2 = obj.getString("apellido_p") + " " + obj.getString("apellido_m") + " "
                    + obj.getString("nombres");
            if (name1.toLowerCase().equals(name2.toLowerCase())) {
                return true;
            } else {
                throw new IllegalStateException("Los datos no coinciden");
            }
        }
    }

    public void addNewPersona(Persona persona) throws Exception {
        Optional<Persona> personaOptional = personaRepository.findById(persona.getId());
        if (personaOptional.isPresent()) {
            throw new IllegalStateException("Este DNI ya se encuentra registrado");
        }
        if (existe(persona)) {
            personaRepository.save(persona);
        } else {
            throw new IllegalStateException("Este DNI no se encuentra en la base de datos");
        }
    }

    @Transactional
    public void updatePersona(String id, String fdv) {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("La persona con el dni: " + id + ", no existe."));
        LocalDate vactime = LocalDate.parse(fdv);
        System.out.println(vactime);
        persona.setFdv(vactime);
    }

}
