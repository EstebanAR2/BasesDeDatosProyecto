package co.edu.unbosque.proyectobases.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.unbosque.proyectobases.model.OrdenCompra;

import java.util.List;

public interface OrdenCompraRepository extends JpaRepository<OrdenCompra, Integer> {
    List<OrdenCompra> findByProveedor_IdProveedor(Integer idProveedor);
}
