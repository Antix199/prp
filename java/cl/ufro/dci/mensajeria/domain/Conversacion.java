package cl.ufro.dci.mensajeria.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Conversacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long conId;
    // Campos básicos de conversación
} 