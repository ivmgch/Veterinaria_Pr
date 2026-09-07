package com.example.relaciones.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "propietarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Propietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 100)
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "El documento es obligatorio")
    @Size(min = 5, max = 20)
    @Column(nullable = false, unique = true)
    private String documento;

    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(
            regexp = "^[0-9]{7,15}$",
            message = "El teléfono debe contener entre 7 y 15 números"
    )
    private String telefono;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Debe ingresar un correo válido")
    @Column(nullable = false, unique = true)
    private String correo;

    @OneToMany(
            mappedBy = "propietario",
            cascade = CascadeType.ALL
    )
    @JsonIgnoreProperties("propietario")

    private List<Mascota> mascotas = new ArrayList<>();
}
