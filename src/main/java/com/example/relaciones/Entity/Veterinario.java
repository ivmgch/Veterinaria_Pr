package com.example.relaciones.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "veterinarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 100)
    private String nombre;

    @NotBlank(
            message = "La tarjeta profesional es obligatoria"
    )
    @Column(nullable = false, unique = true)
    private String tarjetaProfesional;

    @NotBlank(message = "La especialidad es obligatoria")
    private String especialidad;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Correo electrónico no válido")
    @Column(unique = true)
    private String correo;

    @ManyToMany(mappedBy = "veterinarios")
    @JsonIgnoreProperties("veterinarios")
    private Set<Mascota> mascotas = new HashSet<>();
}
