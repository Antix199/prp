package cl.ufro.dci.propiedad.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Hospedaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hosId;

    // Campos básicos de hospedaje
} 