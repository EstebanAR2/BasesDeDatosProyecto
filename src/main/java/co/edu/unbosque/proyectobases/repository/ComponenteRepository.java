package co.edu.unbosque.proyectobases.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.unbosque.proyectobases.model.Componente;

public interface ComponenteRepository extends JpaRepository<Componente, Integer> {
}
