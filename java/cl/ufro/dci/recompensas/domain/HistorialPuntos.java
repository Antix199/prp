package cl.ufro.dci.recompensas.domain;

import cl.ufro.dci.registro.domain.Usuario;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class HistorialPuntos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hisId;

    private Integer hisPuntosTotales;

    @OneToMany(mappedBy = "historial", cascade = CascadeType.ALL)
    private List<Canje> canjes;

    @OneToMany(mappedBy = "historial")
    private List<RegistroEvento> registros;

    @OneToOne
    @JoinColumn(name = "usuId")
    private Usuario usuario;

}
