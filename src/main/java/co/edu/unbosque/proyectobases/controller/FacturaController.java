package co.edu.unbosque.proyectobases.controller;

import co.edu.unbosque.proyectobases.model.Factura;
import co.edu.unbosque.proyectobases.service.FacturaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
@CrossOrigin(origins = "*")
public class FacturaController {

    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @GetMapping
    public List<Factura> listarFacturas() {
        return facturaService.listarFacturas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Factura> obtenerFacturaPorId(@PathVariable Integer id) {
        Factura factura = facturaService.buscarPorId(id);
        return (factura != null)
                ? ResponseEntity.ok(factura)
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/orden/{idOrden}")
    public ResponseEntity<List<Factura>> listarFacturasPorOrden(@PathVariable Integer idOrden) {
        List<Factura> facturas = facturaService.listarPorOrden(idOrden);
        if (facturas == null || facturas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(facturas);
    }

    @PostMapping
    public ResponseEntity<Factura> crearFactura(@RequestBody Factura factura) {
        Factura nueva = facturaService.guardarFactura(factura);
        return ResponseEntity.ok(nueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Factura> actualizarFactura(@PathVariable Integer id, @RequestBody Factura factura) {
        Factura existente = facturaService.buscarPorId(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        factura.setIdFactura(id); 
        Factura actualizada = facturaService.guardarFactura(factura);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFactura(@PathVariable Integer id) {
        Factura existente = facturaService.buscarPorId(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        facturaService.eliminarFactura(id);
        return ResponseEntity.noContent().build();
    }
}
