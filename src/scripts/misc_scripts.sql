-- Consultas de verificación
SELECT * FROM proveedores;
SELECT p.nombre, c.fecha_inicio, c.monto
FROM proveedores p
         JOIN contratos c ON p.id_proveedor = c.id_proveedor;