package cl.ufro.dci.pagos.repository;

import cl.ufro.dci.pagos.domain.MetodoPago;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetodoPagoRepository extends CrudRepository<MetodoPago, Long> {
    // Métodos básicos de CrudRepository
} 