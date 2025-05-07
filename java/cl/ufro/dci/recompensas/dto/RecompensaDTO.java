package cl.ufro.dci.recompensas.dto;

import lombok.Data;

@Data
public class RecompensaDTO {
    private String recNombre;
    private String recDescripcion;
    private Integer recCostoPuntos;
}