package cl.ufro.dci.registro.dto;

import cl.ufro.dci.registro.domain.enums.Rol;
import lombok.Data;

@Data
public class UsuarioDTO {
    private Long id;
    private Rol usuRol;
} 