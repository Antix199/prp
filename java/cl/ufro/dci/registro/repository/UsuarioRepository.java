package cl.ufro.dci.registro.repository;

import cl.ufro.dci.registro.domain.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    // Métodos básicos
} 