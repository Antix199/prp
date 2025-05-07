package cl.ufro.dci.recompensas.service;

import cl.ufro.dci.recompensas.domain.Canje;
import cl.ufro.dci.recompensas.domain.HistorialPuntos;
import cl.ufro.dci.recompensas.domain.Recompensa;
import cl.ufro.dci.recompensas.dto.CanjeDTO;
import cl.ufro.dci.recompensas.dto.RecCanDTO;
import cl.ufro.dci.recompensas.repository.HistorialPuntosRepository;
import cl.ufro.dci.recompensas.repository.RecompensaRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import cl.ufro.dci.recompensas.dto.RecompensaDTO;


import java.util.*;

@Service
public class RecompensasService {

    private final RecompensaRepository recompensaRepository;
    private final HistorialPuntosRepository historialPuntosRepository;

    public RecompensasService(RecompensaRepository recompensaRepository,
                              HistorialPuntosRepository historialPuntosRepository) {
        this.recompensaRepository = recompensaRepository;
        this.historialPuntosRepository = historialPuntosRepository;
    }

    public List<RecompensaDTO> listarRecompensas() {
        List<RecompensaDTO> dtos = new ArrayList<>();
        recompensaRepository.findAll().forEach(r -> {
            RecompensaDTO dto = new RecompensaDTO();
            dto.setRecNombre(r.getRecNombre());
            dto.setRecDescripcion(r.getRecDescripcion());
            dto.setRecCostoPuntos(r.getRecCostoPuntos());
            dtos.add(dto);
        });
        return dtos;
    }
    public Optional<Recompensa> obtenerRecompensaPorId(Long id) {
        return recompensaRepository.findById(id);
    }
    @Transactional
    public ResponseEntity<String> canjearRecompensa(Long usuId, Long recId) {
        Optional<Recompensa> recompensaOpt = recompensaRepository.findById(recId);
        if (recompensaOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Recompensa no encontrada");
        }

        Recompensa recompensa = recompensaOpt.get();
        HistorialPuntos historial = historialPuntosRepository.findByUsuarioId(usuId);

        if (historial == null) {
            return ResponseEntity.badRequest().body("Historial de puntos no encontrado para el usuario");
        }

        if (historial.getHisPuntosTotales() < recompensa.getRecCostoPuntos()) {
            return ResponseEntity.badRequest().body("Puntos insuficientes para canjear la recompensa");
        }

        // Descontar puntos
        historial.setHisPuntosTotales(historial.getHisPuntosTotales() - recompensa.getRecCostoPuntos());

        // Registrar canje
        Canje canje = new Canje();
        canje.setCanCodigoCanje(UUID.randomUUID().toString());
        canje.setCanFecha(new Date());
        canje.setCanEstado(true);
        canje.setRecompensa(recompensa);
        canje.setHistorial(historial);

        historial.getCanjes().add(canje);

        historialPuntosRepository.save(historial); // guarda historial y cascada guarda el canje

        return ResponseEntity.ok("Recompensa canjeada con éxito. Código: " + canje.getCanCodigoCanje());
    }
    public List<CanjeDTO> obtenerHistorialCanjesPorUsuario(Long usuId) {
        // Obtener historial
        HistorialPuntos historial = historialPuntosRepository.findByUsuarioId(usuId);
        if (historial == null) {
            return List.of(); // lista vacía si no hay historial
        }

        List<CanjeDTO> dtos = new ArrayList<>();
        for (Canje canje : historial.getCanjes()) {
            CanjeDTO dto = new CanjeDTO();
            dto.setRecompensaNombre(canje.getRecompensa().getRecNombre());
            dto.setRecompensaDescripcion(canje.getRecompensa().getRecDescripcion());
            dto.setPuntosCosto(canje.getRecompensa().getRecCostoPuntos());
            dto.setCodigoCanje(canje.getCanCodigoCanje());
            dto.setFechaCanje(canje.getCanFecha());
            dtos.add(dto);
        }
        return dtos;
    }

    public HistorialPuntos obtenerHistorialPorUsuario(Long usuId) {
        return historialPuntosRepository.findByUsuarioId(usuId);
    }

    public Optional<RecCanDTO> obtenerDetalleDTO(Long recId) {
        return recompensaRepository.findById(recId).map(r -> {
            RecCanDTO dto = new RecCanDTO();
            dto.setRecId(r.getRecId());
            dto.setRecNombre(r.getRecNombre());
            dto.setRecDescripcion(r.getRecDescripcion());
            dto.setRecCostoPuntos(r.getRecCostoPuntos());
            return dto;
        });
    }

}
