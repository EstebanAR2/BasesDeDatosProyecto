package co.edu.unbosque.proyectobases.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "eventos_proveedor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventoProveedor {
    @Id
    private String id;
    private Integer idProveedor;
    private String tipoEvento;
    private String descripcion;
    private Date fechaEvento;
    private String severidad;
}
