package cl.ufro.dci.recompensas.repository;

import cl.ufro.dci.recompensas.domain.Canje;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CanjeRepository extends CrudRepository<Canje, Long> {
    // Métodos básicos
} 