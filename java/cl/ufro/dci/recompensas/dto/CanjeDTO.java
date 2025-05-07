package cl.ufro.dci.recompensas.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CanjeDTO {
    private String recompensaNombre;
    private String recompensaDescripcion;
    private Integer puntosCosto;
    private String codigoCanje;
    private Date fechaCanje;
}