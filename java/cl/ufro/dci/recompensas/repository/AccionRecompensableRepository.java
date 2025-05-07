package cl.ufro.dci.recompensas.repository;

import cl.ufro.dci.recompensas.domain.AccionRecompensable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccionRecompensableRepository extends CrudRepository<AccionRecompensable, Long> {
    // Métodos básicos
} 