package co.edu.unbosque.proyectobases.service;

import co.edu.unbosque.proyectobases.model.Proveedor;
import co.edu.unbosque.proyectobases.repository.ProveedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService {

    private final ProveedorRepository proveedorRepository;

    public ProveedorService(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    public List<Proveedor> listarProveedores() {
        return proveedorRepository.findAll();
    }

    public Proveedor obtenerProveedorPorId(Integer id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    public Proveedor guardarProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public void eliminarProveedor(Integer id) {
        proveedorRepository.deleteById(id);
    }
}
