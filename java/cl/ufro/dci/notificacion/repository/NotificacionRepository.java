package cl.ufro.dci.notificacion.repository;

import cl.ufro.dci.notificacion.domain.Notificacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacionRepository extends CrudRepository<Notificacion, Long> {
    // Esqueleto base para el repositorio de Notificacion
} 