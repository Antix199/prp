package cl.ufro.dci.pagos.repository;

import cl.ufro.dci.pagos.domain.Transaccion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionRepository extends CrudRepository<Transaccion, Long> {
    // Métodos básicos de CrudRepository
} 