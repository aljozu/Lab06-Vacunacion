package com.alex.lab06alexl.persona;

import java.time.LocalDate;

import javax.persistence.*;

import personadto.PersonaDTO;

@Entity
@Table
public class Persona {

    @Id
    @Column(length = 8, updatable = false)
    private String id;
    private String nombres;
    private String apellidos;
    private LocalDate fdn;
    @Column(length = 9, nullable = true)
    private String tlf;
    @Column(nullable = true)
    private String email;
    @Transient
    private LocalDate fdv;

    public Persona() {
    }

    public Persona(PersonaDTO personaDTO) {
        this.id = personaDTO.getIdDTO();
        this.nombres = personaDTO.getNombresDTO();
        this.apellidos = personaDTO.getApellidosDTO();
        this.fdn = personaDTO.getFdnDTO();
        this.tlf = personaDTO.getTlfDTO();
        this.email = personaDTO.getEmailDTO();
        this.fdv = personaDTO.getFdnDTO();
    }

    public Persona(String id, String nombre, String apellido, LocalDate fdn, String tlf, String email) {
        this.id = id;
        this.nombres = nombre;
        this.apellidos = apellido;
        this.fdn = fdn;
        this.tlf = tlf;
        this.email = email;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFdn() {
        return this.fdn;
    }

    public void setFdn(LocalDate fdn) {
        this.fdn = fdn;
    }

    public String getTlf() {
        return this.tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persona : " + "id = " + id + ", nombre =  " + nombres + ", apellidos = " + apellidos;
    }

    public LocalDate getFdv() {
        fdv = LocalDate.of(2022, fdn.getMonth(), fdn.getDayOfMonth());
        return this.fdv;
    }

    public void setFdv(LocalDate fdv) {
        this.fdv = fdv;
    }
}
