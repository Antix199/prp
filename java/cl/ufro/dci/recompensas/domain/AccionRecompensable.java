package cl.ufro.dci.recompensas.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class AccionRecompensable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accId;

    private String accNombre;
    private String accTipoEvento;
    private String accCondicion;
    private Integer accPuntos;

    @OneToMany(mappedBy = "accionRecompensable")
    private List<RegistroEvento> registros;

} 