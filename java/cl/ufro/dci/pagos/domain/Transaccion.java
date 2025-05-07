package cl.ufro.dci.pagos.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long traId;
    // Campos básicos de transacción
} 