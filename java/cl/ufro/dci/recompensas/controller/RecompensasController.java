package cl.ufro.dci.recompensas.controller;

import cl.ufro.dci.recompensas.domain.HistorialPuntos;
import cl.ufro.dci.recompensas.domain.Recompensa;
import cl.ufro.dci.recompensas.dto.RecCanDTO;
import cl.ufro.dci.recompensas.service.RecompensasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cl.ufro.dci.recompensas.dto.RecompensaDTO;
import cl.ufro.dci.recompensas.dto.CanjeDTO;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/recompensas")
public class RecompensasController {

    private final RecompensasService recompensasService;

    public RecompensasController(RecompensasService recompensasService) {
        this.recompensasService = recompensasService;
    }

    @GetMapping
    public ResponseEntity<List<RecompensaDTO>> listarRecompensas() {
        List<RecompensaDTO> lista = recompensasService.listarRecompensas();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{recId}")
    public ResponseEntity<Recompensa> obtenerPorId(@PathVariable Long recId) {
        return recompensasService.obtenerRecompensaPorId(recId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/detalle/{recId}")
    public ResponseEntity<RecCanDTO> obtenerDetalleRecompensa(@PathVariable Long recId) {
        return recompensasService.obtenerDetalleDTO(recId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("/canjear")
    public ResponseEntity<String> canjearRecompensa(@RequestParam Long usuId, @RequestParam Long recId) {
        return recompensasService.canjearRecompensa(usuId, recId);
    }


    @GetMapping("/historial/{usuId}")
    public ResponseEntity<List<CanjeDTO>> historialDeCanjes(@PathVariable Long usuId) {
        List<CanjeDTO> historial = recompensasService.obtenerHistorialCanjesPorUsuario(usuId);
        return ResponseEntity.ok(historial);
    }

    @GetMapping("/puntos/{usuId}")
    public ResponseEntity<Integer> obtenerPuntosDeUsuario(@PathVariable Long usuId) {
        HistorialPuntos historial = recompensasService.obtenerHistorialPorUsuario(usuId);
        if (historial == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(historial.getHisPuntosTotales());
    }


    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        Map<String, String> status = new HashMap<>();
        status.put("status", "UP");
        status.put("service", "Recompensas Service");
        return ResponseEntity.ok(status);
    }

}
