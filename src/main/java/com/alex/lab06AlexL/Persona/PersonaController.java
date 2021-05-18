package com.alex.lab06AlexL.Persona;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/persona")
public class PersonaController {

    static final Logger logger = Logger.getLogger(PersonaController.class.getName());
    private final PersonaService personaService;

    @Autowired
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping
    public List<Persona> getPersonas() {
        return personaService.getPersonas();
    }

    @GetMapping("/{dni}")
    public String getPersonaById(@PathVariable String dni) {
        var per = personaService.findOneById(dni);
        return "La fecha de vacunación para " + per.getNombres().toUpperCase() + " " + per.getApellidos().toUpperCase() + " será: " + per.getFdv();
    }

    public Persona getPersonaByDNI(String dni) {
        return personaService.findOneById(dni);
    }

    @PostMapping
    public void registerNewPersona(@RequestBody Persona persona) throws Exception {
        personaService.addNewPersona(persona);
    }

    @PutMapping(path = "{personaId}")
    public void updatePersona(@PathVariable("personaId") String id, @RequestParam(required = false) String fdv) {
        personaService.updatePersona(id, fdv);
    }
}
