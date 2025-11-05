package co.edu.unbosque.proyectobases.repository;

import co.edu.unbosque.proyectobases.model.Inventario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InventarioRepository extends MongoRepository<Inventario, Integer> {
    List<Inventario> findByProveedorId(Integer proveedorId);
    List<Inventario> findByUltimaActualizacionAfter(String fecha);
}
