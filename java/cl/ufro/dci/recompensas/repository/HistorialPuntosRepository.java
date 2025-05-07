package cl.ufro.dci.recompensas.repository;

import cl.ufro.dci.recompensas.domain.HistorialPuntos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HistorialPuntosRepository extends JpaRepository<HistorialPuntos, Long> {

    @Query("SELECT h FROM HistorialPuntos h WHERE h.usuario.usuId = :usuId")
    HistorialPuntos findByUsuarioId(@Param("usuId") Long usuId);
}