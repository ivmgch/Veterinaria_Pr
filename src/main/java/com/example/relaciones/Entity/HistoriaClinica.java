package com.example.relaciones.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "historias_clinicas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoriaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La fecha de apertura es obligatoria")
    @PastOrPresent(
            message = "La fecha no puede estar en el futuro"
    )
    private LocalDate fechaApertura;

    @Size(max = 1000)
    private String antecedentes;

    @Size(max = 1000)
    private String observaciones;

    @OneToOne
    @JoinColumn(
            name = "mascota_id",
            nullable = false,
            unique = true
    )
    @JsonIgnoreProperties("historiaClinica")
    private Mascota mascota;
}

