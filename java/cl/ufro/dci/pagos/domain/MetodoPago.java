package cl.ufro.dci.pagos.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class MetodoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long metId;
    // Campos básicos de método de pago
} 