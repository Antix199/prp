package cl.ufro.dci.mensajeria.repository;

import cl.ufro.dci.mensajeria.domain.Mensaje;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensajeRepository extends CrudRepository<Mensaje, Long> {
    // Métodos básicos
} 