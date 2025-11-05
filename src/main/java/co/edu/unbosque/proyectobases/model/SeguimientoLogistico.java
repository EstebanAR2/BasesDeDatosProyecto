package co.edu.unbosque.proyectobases.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "seguimientos_logisticos")
public class SeguimientoLogistico {

    @Id
    private String id;

    private String idcompra;
    private String proveedorId;
    private String estadoActual;
    private LocalDateTime fechaUltimaActualizacion;

    private List<EventoTransporte> eventos;

    @Data
    public static class EventoTransporte {
        private LocalDateTime fecha;
        private String ubicacion;
        private String descripcion;
        private String estado;
    }
}
