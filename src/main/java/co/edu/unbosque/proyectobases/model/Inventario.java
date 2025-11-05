package co.edu.unbosque.proyectobases.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.util.List;

@Data
@Document(collection = "inventarios")
public class Inventario {

    @Id
    private Integer id;

    private String proveedorId;
    private String nombreProveedor;
    private List<ItemInventario> items;
    private String ultimaActualizacion;

    @Data
    public static class ItemInventario {
        private String nombreItem;
        private String codigoItem;
        private int cantidadDisponible;
        private String ubicacionAlmacen;
    }
}
