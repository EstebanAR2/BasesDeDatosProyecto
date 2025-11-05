package co.edu.unbosque.proyectobases.repository;

import co.edu.unbosque.proyectobases.model.SeguimientoLogistico;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SeguimientoLogisticoRepository extends MongoRepository<SeguimientoLogistico, String> {
    List<SeguimientoLogistico> findByIdcompra(String Idcompra);
    List<SeguimientoLogistico> findByProveedorId(String Idproveedor);
    List<SeguimientoLogistico> findByEstadoActual(String EstadoActual);
}
