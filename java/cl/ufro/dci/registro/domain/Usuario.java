package cl.ufro.dci.registro.domain;

import cl.ufro.dci.registro.domain.enums.Rol;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuId;
    
    @Enumerated(EnumType.STRING)
    private Rol usuRol;
    

} 