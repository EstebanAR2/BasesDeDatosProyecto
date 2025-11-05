 package co.edu.unbosque.proyectobases.repository;

 import org.springframework.data.mongodb.repository.MongoRepository;
 import co.edu.unbosque.proyectobases.model.SeguimientoEnvio;
 import org.springframework.stereotype.Repository;

 import java.util.List;

 @Repository
 public interface SeguimientoEnvioRepository extends MongoRepository<SeguimientoEnvio, String> {
}
