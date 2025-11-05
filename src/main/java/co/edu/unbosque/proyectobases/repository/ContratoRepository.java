package co.edu.unbosque.proyectobases.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.unbosque.proyectobases.model.Contrato;

public interface ContratoRepository extends JpaRepository<Contrato, Integer> {
}
