package com.todocodeacademy.clinicaVeterinaria.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Owner {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id_owner;
    private String nombre;
    private String apellido;
    private String celular;

    public Owner() {
    }

    public Owner(Long id_owner, String nombre, String apellido, String celular) {
        this.id_owner = id_owner;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
    }
}
