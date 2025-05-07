package cl.ufro.dci.busqueda.repository;

import cl.ufro.dci.busqueda.domain.Busqueda;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusquedaRepository extends CrudRepository<Busqueda, Long> {
    // Métodos básicos
} 