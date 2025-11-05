package co.edu.unbosque.proyectobases.service;

import co.edu.unbosque.proyectobases.model.SeguimientoLogistico;
import co.edu.unbosque.proyectobases.repository.SeguimientoLogisticoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SeguimientoLogisticoService {

    private final SeguimientoLogisticoRepository seguimientoLogisticoRepository;

    public SeguimientoLogisticoService(SeguimientoLogisticoRepository seguimientoLogisticoRepository) {
        this.seguimientoLogisticoRepository = seguimientoLogisticoRepository;
    }


    public List<SeguimientoLogistico> listarSeguimientos() {
        return seguimientoLogisticoRepository.findAll();
    }


    public SeguimientoLogistico buscarPorId(String id) {
        return seguimientoLogisticoRepository.findById(id).orElse(null);
    }


    public List<SeguimientoLogistico> listarPorProveedor(String idProveedor) {
        return seguimientoLogisticoRepository.findByProveedorId(idProveedor);
    }
    public List<SeguimientoLogistico> listarPorEstadoActual(String EstadoActual) {
        return seguimientoLogisticoRepository.findByEstadoActual(EstadoActual);
    }


    public List<SeguimientoLogistico> listarPorOrdenCompra(String idCompra) {
        return seguimientoLogisticoRepository.findByIdcompra(idCompra);
    }


    public SeguimientoLogistico guardarSeguimiento(SeguimientoLogistico seguimiento) {
        return seguimientoLogisticoRepository.save(seguimiento);
    }


    public void eliminarSeguimiento(String id) {
        seguimientoLogisticoRepository.deleteById(id);
    }
}
