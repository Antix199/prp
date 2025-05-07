package cl.ufro.dci.busqueda.repository;

import cl.ufro.dci.busqueda.domain.Ubicacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UbicacionRepository extends CrudRepository<Ubicacion, Long> {
    // Métodos básicos
} 