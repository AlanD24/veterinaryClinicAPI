package com.todocodeacademy.clinicaVeterinaria.service;
import com.todocodeacademy.clinicaVeterinaria.model.Owner;
import com.todocodeacademy.clinicaVeterinaria.repository.IOwnerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService implements IOwnerService {
    
    @Autowired
    private IOwnerRepository ownerRepo;
    
    @Override
    public void addOwner(Owner owner) {
        ownerRepo.save(owner);
    }

    @Override
    public Owner getOwner(Long id) {
        return ownerRepo.findById(id).orElse(null);
    }

    @Override
    public List<Owner> getOwners() {
        return ownerRepo.findAll();
    }

    @Override
    public Owner editOwner(Long id, String nombre, String apellido, String celular) {
        // Primero encontramos al owner
        Owner owner = this.getOwner(id);
        
        // Luego modificamos a nivel logico
        owner.setNombre(nombre);
        owner.setApellido(apellido);
        owner.setCelular(celular);
        
        // Guardamos cambios
        this.addOwner(owner);
        
        return owner;
    }

    @Override
    public void deleteOwner(Long id) {
        ownerRepo.deleteById(id);
    }
}
