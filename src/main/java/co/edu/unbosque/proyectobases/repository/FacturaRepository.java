package co.edu.unbosque.proyectobases.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.unbosque.proyectobases.model.Factura;

import java.util.List;

public interface FacturaRepository extends JpaRepository<Factura, Integer> {
    List<Factura> findByOrden_IdOrden(Integer idOrden);
}
