package com.example.relaciones.Repository;

import com.example.relaciones.Entity.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {

    Optional<Veterinario>findByTarjetaProfesional(String tarjetaProfesional);

    List<Veterinario>findByEspecialidadContainingIgnoreCase(String especialidad);
}
