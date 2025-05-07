package cl.ufro.dci.recompensas.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Canje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long canId;

    private String canCodigoCanje;
    private Date canFecha;
    private Boolean canEstado;

    @ManyToOne
    @JoinColumn(name = "recId")
    private Recompensa recompensa;

    @ManyToOne
    @JoinColumn(name = "hisId")
    private HistorialPuntos historial;


}


