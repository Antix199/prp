package cl.ufro.dci.propiedad.repository;

import cl.ufro.dci.propiedad.domain.Hospedaje;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospedajeRepository extends CrudRepository<Hospedaje, Long> {
    // Métodos básicos de CrudRepository
} 