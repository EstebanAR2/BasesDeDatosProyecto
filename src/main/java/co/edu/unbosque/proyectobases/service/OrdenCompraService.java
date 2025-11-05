package co.edu.unbosque.proyectobases.service;

import co.edu.unbosque.proyectobases.model.OrdenCompra;
import co.edu.unbosque.proyectobases.repository.OrdenCompraRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrdenCompraService {
    private final OrdenCompraRepository ordenRepository;

    public OrdenCompraService(OrdenCompraRepository ordenRepository) {
        this.ordenRepository = ordenRepository;
    }

    public List<OrdenCompra> listarOrdenes() {
        return ordenRepository.findAll();
    }

    public OrdenCompra guardarOrden(OrdenCompra orden) {
        return ordenRepository.save(orden);
    }

    public OrdenCompra buscarPorId(Integer id) {
        return ordenRepository.findById(id).orElse(null);
    }

    public List<OrdenCompra> listarPorProveedor(Integer idProveedor) {
        return ordenRepository.findByProveedor_IdProveedor(idProveedor);
    }

    public void eliminarOrden(Integer id) {
        ordenRepository.deleteById(id);
    }
}
