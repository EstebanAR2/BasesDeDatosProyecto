package co.edu.unbosque.proyectobases.controller;

import co.edu.unbosque.proyectobases.model.BitacoraOperacion;
import co.edu.unbosque.proyectobases.service.BitacoraOperacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bitacora-operaciones")
@CrossOrigin(origins = "*")
public class BitacoraOperacionController {

    private final BitacoraOperacionService bitacoraService;

    public BitacoraOperacionController(BitacoraOperacionService bitacoraService) {
        this.bitacoraService = bitacoraService;
    }


    @GetMapping
    public List<BitacoraOperacion> listarBitacoras() {
        return bitacoraService.listarBitacoras();
    }


    @GetMapping("/{id}")
    public ResponseEntity<BitacoraOperacion> obtenerPorId(@PathVariable Integer id) {
        BitacoraOperacion bitacora = bitacoraService.buscarPorId(id);
        return (bitacora != null)
                ? ResponseEntity.ok(bitacora)
                : ResponseEntity.notFound().build();
    }


    @GetMapping("/usuario/{usuario}")
    public ResponseEntity<List<BitacoraOperacion>> listarPorUsuario(@PathVariable String usuario) {
        List<BitacoraOperacion> bitacoras = bitacoraService.listarPorUsuario(usuario);
        if (bitacoras == null || bitacoras.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(bitacoras);
    }


    @PostMapping
    public ResponseEntity<BitacoraOperacion> crearBitacora(@RequestBody BitacoraOperacion bitacora) {
        BitacoraOperacion nueva = bitacoraService.guardarBitacora(bitacora);
        return ResponseEntity.ok(nueva);
    }


    @PutMapping("/{id}")
    public ResponseEntity<BitacoraOperacion> actualizarBitacora(@PathVariable Integer id, @RequestBody BitacoraOperacion bitacora) {
        BitacoraOperacion existente = bitacoraService.buscarPorId(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        bitacora.setId(id);
        BitacoraOperacion actualizada = bitacoraService.guardarBitacora(bitacora);
        return ResponseEntity.ok(actualizada);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarBitacora(@PathVariable Integer id) {
        BitacoraOperacion existente = bitacoraService.buscarPorId(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        bitacoraService.eliminarBitacora(id);
        return ResponseEntity.noContent().build();
    }
}
