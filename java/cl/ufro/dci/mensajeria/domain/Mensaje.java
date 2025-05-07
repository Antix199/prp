package cl.ufro.dci.mensajeria.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menId;
    // Campos básicos de mensaje
} 