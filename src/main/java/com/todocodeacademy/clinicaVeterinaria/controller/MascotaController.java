package com.todocodeacademy.clinicaVeterinaria.controller;
import com.todocodeacademy.clinicaVeterinaria.dto.MascotaOwner;
import com.todocodeacademy.clinicaVeterinaria.model.Mascota;
import com.todocodeacademy.clinicaVeterinaria.service.IMascotaService;
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
public class MascotaController {
    
    @Autowired
    IMascotaService mascotaServ;
    
    // 1.- Crear un CRUD de mascotas
    @PostMapping ("/mascota/nueva")
    public String addMascota(@RequestBody Mascota pet) {
        mascotaServ.addMascota(pet);
        return "Nueva mascota agregada!";
    }
    
    @GetMapping ("/mascota/{id}")
    public Mascota getMascota(@PathVariable Long id) {
        return mascotaServ.getMascota(id);
    }
    
    @GetMapping ("/mascotas")
    public List<Mascota> getMascotas() {
        return mascotaServ.getMascotas();
    }
    
    @PutMapping ("/mascota/editar/{id}")
    public Mascota editMascota(@PathVariable Long id,
            @RequestParam(required=false, name="nombre") String nombre,
            @RequestParam(required=false, name="especie") String especie,
            @RequestParam(required=false, name="raza") String raza,
            @RequestParam(required=false, name="color") String color
            ) {
        Mascota pet = mascotaServ.editMascota(id, nombre, especie, raza, color);
        
        return pet;
    }
    
    @DeleteMapping ("/mascota/borrar/{id}")
    public String deleteMascota(@PathVariable Long id) {
        mascotaServ.deleteMascota(id);
        return "Se ha eliminado la mascota";
    }
    
    // 3.- Obtener todos los perros raza caniche
    @GetMapping ("/perros/caniche")
    public List<Mascota> getPerrosCaniche() {
        return mascotaServ.getPerrosCaniche();
    }
    
    // 4.- Obtener el dueño de una determinada mascota
    @GetMapping ("/owner/mascota/{id}")
    public MascotaOwner getOwnerDeMascota(@PathVariable Long id) {
        return mascotaServ.getOwnerDeMascota(id);
    }
}
