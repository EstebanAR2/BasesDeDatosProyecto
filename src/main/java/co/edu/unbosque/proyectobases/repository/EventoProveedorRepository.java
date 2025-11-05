package co.edu.unbosque.proyectobases.repository;

import co.edu.unbosque.proyectobases.model.EventoProveedor;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface EventoProveedorRepository extends MongoRepository<EventoProveedor, String> {
    List<EventoProveedor> findByIdProveedor(Integer idProveedor);
}
