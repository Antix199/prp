package cl.ufro.dci.recompensas.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class RegistroEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long regId;

    private Date regFecha;

    @ManyToOne
    @JoinColumn(name = "hisId")
    private HistorialPuntos historial;

    @ManyToOne
    @JoinColumn(name = "accId")
    private AccionRecompensable accionRecompensable;


}
