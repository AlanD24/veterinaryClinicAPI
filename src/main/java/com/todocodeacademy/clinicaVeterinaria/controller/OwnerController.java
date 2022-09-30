package com.todocodeacademy.clinicaVeterinaria.controller;
import com.todocodeacademy.clinicaVeterinaria.model.Owner;
import com.todocodeacademy.clinicaVeterinaria.service.IOwnerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OwnerController {
    
    @Autowired
    private IOwnerService ownerServ;
    
    // 2.- Crear CRUD de dueño 
    @PostMapping ("/owner/nuevo")
    public String addOwner(@RequestBody Owner owner) {
        ownerServ.addOwner(owner);
        return "Has creado un nuevo dueño";
    }
    
    @GetMapping ("/owner/{id}")
    public Owner getOwner(@PathVariable Long id) {
        return ownerServ.getOwner(id);
    }
    
    @GetMapping ("/owners")
    public List<Owner> getOwners() {
        return ownerServ.getOwners();
    }
    
    @PutMapping ("/owner/{id}")
    public Owner editOwner(@PathVariable Long id,
            @RequestParam(required=false, name="nombre") String nombre, 
            @RequestParam(required=false, name="apellido") String apellido, 
            @RequestParam(required=false, name="celular") String celular) {
        // Guardamos
        ownerServ.editOwner(id, nombre, apellido, celular);
        
        // Primero buscamos al dueño
        Owner owner = this.getOwner(id);
        
        return owner;
    }
    
    @DeleteMapping ("/owner/borrar/{id}")
    public String deleteOwner(@PathVariable Long id) {
        ownerServ.deleteOwner(id);
        return "Has eliminado correctamente al dueño";
    }
}
