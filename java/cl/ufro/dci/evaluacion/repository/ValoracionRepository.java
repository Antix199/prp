package cl.ufro.dci.evaluacion.repository;

import cl.ufro.dci.evaluacion.domain.Valoracion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValoracionRepository extends CrudRepository<Valoracion, Long> {
    // Métodos básicos
} 