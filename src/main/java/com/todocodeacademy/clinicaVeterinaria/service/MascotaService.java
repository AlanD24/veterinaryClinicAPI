package com.todocodeacademy.clinicaVeterinaria.service;
import com.todocodeacademy.clinicaVeterinaria.dto.MascotaOwner;
import com.todocodeacademy.clinicaVeterinaria.model.Mascota;
import com.todocodeacademy.clinicaVeterinaria.repository.IMascotaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MascotaService implements IMascotaService {
    
    @Autowired
    private IMascotaRepository mascotaRepo;
    
    @Override
    public void addMascota(Mascota pet) {
        mascotaRepo.save(pet);
    }

    @Override
    public Mascota getMascota(Long id) {
        return mascotaRepo.findById(id).orElse(null);
    }

    @Override
    public List<Mascota> getMascotas() {
        return mascotaRepo.findAll();
    }

    @Override
    public Mascota editMascota(Long id, String nombre, String especie, String raza, String color) {
        // Primero buscamos la mascota
        Mascota pet = this.getMascota(id);
        
        // Luego modificamosa nivel logico
        pet.setNombre(nombre);
        pet.setEspecie(especie);
        pet.setRaza(raza);
        pet.setColor(color);
        
        
        // Guardamos el nuevo valor
        this.addMascota(pet);
        
        // Regresamos la mascota modificada
        return pet;
    }

    @Override
    public void deleteMascota(Long id) {
        mascotaRepo.deleteById(id);
    }

    @Override
    public List<Mascota> getPerrosCaniche() {
        List<Mascota> todasLasMascotas = this.getMascotas();
        List<Mascota> perrosCaniche = new ArrayList<>();
        
        for(Mascota pet: todasLasMascotas) {
            if(pet.getEspecie().contains("perro") && pet.getRaza().contains("caniche")) {
                perrosCaniche.add(pet);
            }
        }
        
        return perrosCaniche;
    }

    @Override
    public MascotaOwner getOwnerDeMascota(Long id_mascota) {
        // Primero creamos el DTO
        MascotaOwner ownerDeMascota = new MascotaOwner();
        
        // Luego buscamos a la mascota
        Mascota pet = this.getMascota(id_mascota);
        
        // Despues asignamos valores
        ownerDeMascota.setNombre_mascota(pet.getNombre());
        ownerDeMascota.setEspecie(pet.getEspecie());
        ownerDeMascota.setRaza(pet.getRaza());
        ownerDeMascota.setNombre_owner(pet.getOwner().getNombre());
        ownerDeMascota.setApellido_owner(pet.getOwner().getApellido());
        
        return ownerDeMascota;
    }
    
}
