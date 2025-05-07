package cl.ufro.dci.recompensas.repository;

import cl.ufro.dci.recompensas.domain.RegistroEvento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroEventoRepository extends CrudRepository<RegistroEvento, Long> {
    // Métodos básicos
}