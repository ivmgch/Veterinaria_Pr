package com.example.relaciones.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "mascotas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 50)
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "La especie es obligatoria")
    private String especie;

    @NotBlank(message = "La raza es obligatoria")
    private String raza;

    @NotNull(message = "La edad es obligatoria")
    @Min(value = 0, message = "La edad no puede ser negativa")
    @Max(value = 50, message = "La edad no es válida")
    private Integer edad;

    @NotNull(message = "El peso es obligatorio")
    @Positive(message = "El peso debe ser mayor que cero")
    private Double peso;

    // MUCHAS MASCOTAS -> UN PROPIETARIO

    @ManyToOne
    @JoinColumn(
            name = "propietario_id",
            nullable = false
    )
    @JsonIgnoreProperties("mascotas")
    private Propietario propietario;


    // UNA MASCOTA -> UNA HISTORIA CLÍNICA

    @OneToOne(
            mappedBy = "mascota",
            cascade = CascadeType.ALL
    )
    @JsonIgnoreProperties("mascota")
    private HistoriaClinica historiaClinica;


    // MUCHAS MASCOTAS <-> MUCHOS VETERINARIOS

    @ManyToMany
    @JoinTable(
            name = "mascota_veterinario",

            joinColumns =
            @JoinColumn(name = "mascota_id"),

            inverseJoinColumns =
            @JoinColumn(name = "veterinario_id")
    )
    @JsonIgnoreProperties("mascotas")

    private Set<Veterinario> veterinarios = new HashSet<>();
}
