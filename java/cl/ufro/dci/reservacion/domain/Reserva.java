package cl.ufro.dci.reservacion.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resId;
} 