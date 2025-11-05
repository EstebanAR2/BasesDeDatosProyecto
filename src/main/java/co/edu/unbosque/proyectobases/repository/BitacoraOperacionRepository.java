package co.edu.unbosque.proyectobases.repository;

import co.edu.unbosque.proyectobases.model.BitacoraOperacion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BitacoraOperacionRepository extends MongoRepository<BitacoraOperacion, Integer> {


    List<BitacoraOperacion> findByUsuario(String usuario);

    List<BitacoraOperacion> findByTipoOperacion(String tipoOperacion);
}
