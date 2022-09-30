package com.todocodeacademy.clinicaVeterinaria.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Mascota {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String especie;
    private String raza;
    private String color;
    @OneToOne
    @JoinColumn (name="id_owner", referencedColumnName="id_owner")
    private Owner owner;

    public Mascota() {
    }

    public Mascota(Long id, String nombre, String especie, String raza, String color) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.color = color;
    }
}
