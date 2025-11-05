package co.edu.unbosque.proyectobases.repository;

import co.edu.unbosque.proyectobases.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {}
