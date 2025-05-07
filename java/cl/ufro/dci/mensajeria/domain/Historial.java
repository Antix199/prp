package cl.ufro.dci.mensajeria.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Historial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hisId;
    // Campos básicos de historial
} 