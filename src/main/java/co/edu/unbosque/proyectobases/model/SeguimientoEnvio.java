package co.edu.unbosque.proyectobases.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "seguimientos_envio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeguimientoEnvio {
    @Id
    private String id;
    private Integer idOrden;
    private String ubicacionActual;
    private String estado;
    private Date fechaActualizacion;
}
