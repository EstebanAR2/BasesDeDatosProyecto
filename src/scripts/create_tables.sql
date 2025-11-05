CREATE DATABASE wec_proveedores;
USE wec_proveedores;

CREATE TABLE proveedores (
                             id_proveedor INT AUTO_INCREMENT PRIMARY KEY,
                             nombre VARCHAR(100),
                             pais VARCHAR(50),
                             contacto VARCHAR(100),
                             telefono VARCHAR(20),
                             correo VARCHAR(100),
                             direccion VARCHAR(150)
);


CREATE TABLE contratos (
                           id_contrato INT AUTO_INCREMENT PRIMARY KEY,
                           id_proveedor INT,
                           fecha_inicio DATE,
                           fecha_fin DATE,
                           valor_contrato DECIMAL(15,2),
                           descripcion TEXT,
                           FOREIGN KEY (id_proveedor) REFERENCES proveedores(id_proveedor)
);


CREATE TABLE componentes (
                             id_componente INT AUTO_INCREMENT PRIMARY KEY,
                             nombre VARCHAR(100),
                             tipo VARCHAR(50),
                             descripcion TEXT,
                             stock_minimo INT,
                             stock_actual INT
);


CREATE TABLE ordenes_compra (
                                id_orden INT AUTO_INCREMENT PRIMARY KEY,
                                id_proveedor INT,
                                id_componente INT,
                                cantidad INT,
                                fecha_orden DATE,
                                fecha_entrega_estimada DATE,
                                estado VARCHAR(50),
                                FOREIGN KEY (id_proveedor) REFERENCES proveedores(id_proveedor),
                                FOREIGN KEY (id_componente) REFERENCES componentes(id_componente)
);


CREATE TABLE facturas (
                          id_factura INT AUTO_INCREMENT PRIMARY KEY,
                          id_orden INT,
                          fecha_emision DATE,
                          monto_total DECIMAL(15,2),
                          metodo_pago VARCHAR(50),
                          FOREIGN KEY (id_orden) REFERENCES ordenes_compra(id_orden)
);


CREATE TABLE usuarios_sistema (
                                  id_usuario INT AUTO_INCREMENT PRIMARY KEY,
                                  nombre_usuario VARCHAR(50),
                                  contrasena VARCHAR(255),
                                  rol VARCHAR(50)
);


CREATE TABLE auditorias (
                            id_auditoria INT AUTO_INCREMENT PRIMARY KEY,
                            id_usuario INT,
                            accion TEXT,
                            fecha_accion DATETIME,
                            FOREIGN KEY (id_usuario) REFERENCES usuarios_sistema(id_usuario)
);