package cl.ufro.dci.mensajeria.repository;

import cl.ufro.dci.mensajeria.domain.Conversacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversacionRepository extends CrudRepository<Conversacion, Long> {
    // Métodos básicos
} 