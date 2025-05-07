package cl.ufro.dci.recompensas.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Recompensa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recId;

    private String recNombre;
    private String recDescripcion;
    private Integer recCostoPuntos;

    @OneToMany(mappedBy = "recompensa")
    private List<Canje> canjes;

} 