package co.edu.unbosque.proyectobases.controller;

import co.edu.unbosque.proyectobases.model.SeguimientoEnvio;
import co.edu.unbosque.proyectobases.service.SeguimientoEnvioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seguimientos-envio")
@CrossOrigin(origins = "*")
public class SeguimientoEnvioController {

  private final SeguimientoEnvioService seguimientoService;

  public SeguimientoEnvioController(SeguimientoEnvioService seguimientoService) {
       this.seguimientoService = seguimientoService;
    }

  @GetMapping
  public List<SeguimientoEnvio> listarSeguimientos() {
      return seguimientoService.listarSeguimientos();
  }

  @GetMapping("/{id}")
  public ResponseEntity<SeguimientoEnvio> obtenerPorId(@PathVariable String id) {


      SeguimientoEnvio seguimiento = seguimientoService.buscarPorId(id);
      return (seguimiento != null)
              ? ResponseEntity.ok(seguimiento)
              : ResponseEntity.notFound().build();
  }

  @GetMapping("/orden/{idOrden}")
  public ResponseEntity<List<SeguimientoEnvio>> listarPorOrden(@PathVariable Integer idOrden) {
      List<SeguimientoEnvio> seguimientos = seguimientoService.listarPorOrden(idOrden);
      if (seguimientos == null || seguimientos.isEmpty()) {
          return ResponseEntity.noContent().build();
      }
      return ResponseEntity.ok(seguimientos);
  }

  @PostMapping
  public ResponseEntity<SeguimientoEnvio> crearSeguimiento(@RequestBody SeguimientoEnvio seguimiento) {
      SeguimientoEnvio nuevo = seguimientoService.guardarSeguimiento(seguimiento);
      return ResponseEntity.ok(nuevo);
  }

  @PutMapping("/{id}")
  public ResponseEntity<SeguimientoEnvio> actualizarSeguimiento(@PathVariable String id, @RequestBody SeguimientoEnvio seguimiento) {
      SeguimientoEnvio existente = seguimientoService.buscarPorId(id);
      if (existente == null) {
          return ResponseEntity.notFound().build();
      }
     seguimiento.setId(id);
      SeguimientoEnvio actualizado = seguimientoService.guardarSeguimiento(seguimiento);
      return ResponseEntity.ok(actualizado);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminarSeguimiento(@PathVariable String id) {
      SeguimientoEnvio existente = seguimientoService.buscarPorId(id);
      if (existente == null) {
          return ResponseEntity.notFound().build();
      }
      seguimientoService.eliminarSeguimiento(id);
      return ResponseEntity.noContent().build();
  }
}
