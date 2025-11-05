package co.edu.unbosque.proyectobases.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Document(collection = "bitacora_operaciones")
public class BitacoraOperacion {

    @Id
    private Integer id;

    private String usuario;
    private String tipoOperacion;
    private String entidadAfectada;
    private String descripcion;
    private LocalDateTime fechaHora;

   @Data
    public static class BitacoraOperaciones {
       private String usuario;
       private String tipoOperacion;
       private String entidadAfectada;
       private String descripcion;
       private LocalDateTime fechaHora;
   }

}
