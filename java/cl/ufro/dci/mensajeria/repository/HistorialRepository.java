package cl.ufro.dci.mensajeria.repository;

import cl.ufro.dci.mensajeria.domain.Historial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialRepository extends CrudRepository<Historial, Long> {
    // Métodos básicos
} 