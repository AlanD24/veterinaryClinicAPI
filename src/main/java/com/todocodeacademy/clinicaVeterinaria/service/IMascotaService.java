package com.todocodeacademy.clinicaVeterinaria.service;
import com.todocodeacademy.clinicaVeterinaria.dto.MascotaOwner;
import com.todocodeacademy.clinicaVeterinaria.model.Mascota;
import java.util.List;

public interface IMascotaService {
    // 1.- Crear un CRUD para mascota
    public void addMascota(Mascota pet);
    
    public Mascota getMascota(Long id);
    
    public List<Mascota> getMascotas();

    public Mascota editMascota(Long id, String nombre,
        String especie, String raza, String color);
    
    public void deleteMascota(Long id);
    
    // 3.- Obtener mascotas especie perro y raza "Caniche"
    public List<Mascota> getPerrosCaniche();

    /*
        4.- Obtener DTO de mascota con dueño
        nombre_mascota, especie, raza, nombre_owner, apellido_owner
    */
    public MascotaOwner getOwnerDeMascota(Long id_mascota);
}
