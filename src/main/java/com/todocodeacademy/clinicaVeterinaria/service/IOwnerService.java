package com.todocodeacademy.clinicaVeterinaria.service;
import com.todocodeacademy.clinicaVeterinaria.model.Owner;
import java.util.List;

public interface IOwnerService {
    // 2.- Crear un CRUD para Owner(Dueño)
    public void addOwner(Owner owner);
    
    public Owner getOwner(Long id);
    
    public List<Owner> getOwners();
    
    public Owner editOwner(Long id, String nombre, 
        String apellido, String celular);
    
    public void deleteOwner(Long id);
}
