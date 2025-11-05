USE wec_logistica;

INSERT INTO proveedores (nombre, pais, tipo_producto) VALUES
                                                          ('Toyota GAZOO Parts', 'Japón', 'Motor'),
                                                          ('Michelin Racing', 'Francia', 'Neumáticos'),
                                                          ('Brembo Performance', 'Italia', 'Frenos');

INSERT INTO componentes (nombre, descripcion, stock_actual, stock_minimo) VALUES
                                                                              ('Motor V6 Híbrido', 'Motor de competición híbrido de 3.5L', 5, 2),
                                                                              ('Discos de freno carbono', 'Discos de freno ventilados para altas temperaturas', 10, 3);

INSERT INTO contratos (id_proveedor, fecha_inicio, fecha_fin, monto) VALUES
                                                                         (1, '2024-01-01', '2025-12-31', 1200000.00),
                                                                         (2, '2024-05-01', '2025-05-01', 450000.00);