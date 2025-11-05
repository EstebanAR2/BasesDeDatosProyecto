package co.edu.unbosque.proyectobases.service;

import co.edu.unbosque.proyectobases.model.Factura;
import co.edu.unbosque.proyectobases.repository.FacturaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FacturaService {
    private final FacturaRepository facturaRepository;

    public FacturaService(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    public List<Factura> listarFacturas() {
        return facturaRepository.findAll();
    }

    public Factura guardarFactura(Factura factura) {
        return facturaRepository.save(factura);
    }

    public Factura buscarPorId(Integer id) {
        return facturaRepository.findById(id).orElse(null);
    }

    public List<Factura> listarPorOrden(Integer idOrden) {
        return facturaRepository.findByOrden_IdOrden(idOrden);
    }

    public void eliminarFactura(Integer id) {
        facturaRepository.deleteById(id);
    }
}
