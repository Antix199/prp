package cl.ufro.dci.reservacion.repository;

import cl.ufro.dci.reservacion.domain.Reserva;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends CrudRepository<Reserva, Long> {
    // Métodos básicos de CrudRepository
} 