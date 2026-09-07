package com.example.relaciones.Repository;

import com.example.relaciones.Entity.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PropietarioRepository extends JpaRepository<Propietario, Long> {

    Optional<Propietario> findByDocumento(String documento);

    Optional<Propietario> findByCorreo(String correo);
}
