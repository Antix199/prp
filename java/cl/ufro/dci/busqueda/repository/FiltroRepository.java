package cl.ufro.dci.busqueda.repository;

import cl.ufro.dci.busqueda.domain.Filtro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiltroRepository extends CrudRepository<Filtro, Long> {
    // Métodos básicos
} 