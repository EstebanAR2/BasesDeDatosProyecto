db.evaluaciones_proveedores.aggregate([
    { $group: { _id: "$proveedor", promedio: { $avg: "$puntaje" } } }
]);