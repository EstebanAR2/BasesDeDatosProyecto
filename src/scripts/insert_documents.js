db.bitacora_operaciones.insertMany([
    { usuario: "admin", accion: "Creación de contrato", fecha: new Date() },
    { usuario: "logistica1", accion: "Actualización de stock", fecha: new Date() }
]);

db.evaluaciones_proveedores.insertMany([
    { proveedor: "Michelin Racing", puntaje: 9.5, criterios: { calidad: 10, puntualidad: 9 } },
    { proveedor: "Brembo Performance", puntaje: 8.8, criterios: { calidad: 9, puntualidad: 8.5 } }
]);