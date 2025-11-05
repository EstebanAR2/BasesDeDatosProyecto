package co.edu.unbosque.proyectobases.service;

import co.edu.unbosque.proyectobases.model.Inventario;
import co.edu.unbosque.proyectobases.repository.InventarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InventarioService {

    private final InventarioRepository inventarioRepository;

    public InventarioService(InventarioRepository inventarioRepository) {
        this.inventarioRepository = inventarioRepository;
    }

    public List<Inventario> obtenerTodos() {
        return inventarioRepository.findAll();
    }

    public Optional<Inventario> obtenerPorId(int id) {
        return inventarioRepository.findById(id);
    }

    public List<Inventario> obtenerPorProveedor(int proveedorId) {
        return inventarioRepository.findByProveedorId(proveedorId);
    }

    public Inventario guardar(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    public Inventario actualizar(int id, Inventario nuevoInventario) {
        return inventarioRepository.findById(id).map(inv -> {
            inv.setProveedorId(nuevoInventario.getProveedorId());
            inv.setNombreProveedor(nuevoInventario.getNombreProveedor());
            inv.setItems(nuevoInventario.getItems());
            inv.setUltimaActualizacion(nuevoInventario.getUltimaActualizacion());
            return inventarioRepository.save(inv);
        }).orElseThrow(() -> new RuntimeException("Inventario no encontrado con ID: " + id));
    }

    public void eliminar(int id) {
        inventarioRepository.deleteById(id);
    }
}
