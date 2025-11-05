package co.edu.unbosque.proyectobases.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Table(name = "facturas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFactura;

    @ManyToOne
    @JoinColumn(name = "id_orden")
    private OrdenCompra orden;

    private Date fechaEmision;
    private Double montoTotal;
    private String metodoPago;
}
