package co.edu.unbosque.proyectobases.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "componentes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Componente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComponente;

    private String nombre;
    private String tipo;
    private String descripcion;
    private Integer stockMinimo;
    private Integer stockActual;
}
