package com.todocodeacademy.clinicaVeterinaria.dto;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MascotaOwner {
    private String nombre_mascota;
    private String especie;
    private String raza;
    private String nombre_owner;
    private String apellido_owner;

    public MascotaOwner() {
    }

    public MascotaOwner(String nombre_mascota, String especie, String raza, String nombre_owner, String apellido_owner) {
        this.nombre_mascota = nombre_mascota;
        this.especie = especie;
        this.raza = raza;
        this.nombre_owner = nombre_owner;
        this.apellido_owner = apellido_owner;
    }
}
