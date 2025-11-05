package co.edu.unbosque.proyectobases.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "contratos")
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContrato;

    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;

    private Date fechaInicio;
    private Date fechaFin;
    private Double valorContrato;
    private String descripcion;
}
