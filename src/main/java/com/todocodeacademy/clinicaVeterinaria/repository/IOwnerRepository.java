package com.todocodeacademy.clinicaVeterinaria.repository;
import com.todocodeacademy.clinicaVeterinaria.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOwnerRepository extends JpaRepository <Owner, Long> {
    
}
