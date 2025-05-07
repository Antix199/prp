package cl.ufro.dci.recompensas.repository;

import cl.ufro.dci.recompensas.domain.Recompensa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecompensaRepository extends CrudRepository<Recompensa, Long> {
    // Métodos básicos
} 