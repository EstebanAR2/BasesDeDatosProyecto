# 📘 README — Scripts de Implementación del Modelo Físico

*Proyecto:* Cadena de Gestión y Logística de Proveedores — WEC Team
*Materia:* Bases de Datos II
*Universidad:* Universidad el bosque
*Autores:* Santiago Arciniegas Giraldo, Esteban Arango, José David Castellanos
*Fecha:* 5/11/2025

---

## 🧩 Descripción General

Este documento describe los *scripts SQL y NoSQL* que permiten la implementación del *modelo físico* del sistema de gestión logística y de proveedores de un equipo de competición del World Endurance Championship (WEC).

El objetivo es simular un entorno de producción real, donde la información estructurada (relacional) y no estructurada (documental) se integran para cubrir diferentes necesidades de almacenamiento y análisis de datos.

---

## 📂 Estructura del proyecto


/scripts
│
├── mysql/
│   ├── 01_create_tables.sql
│   ├── 02_insert_data.sql
│   ├── 03_misc_scripts.sql
│
├── mongodb/
│   ├── 01_create_collections.js
│   ├── 02_insert_documents.js
│   ├── 03_misc_scripts.js
│
└── README.md


---

## 🐬 Sección MySQL (Base de datos relacional)

### 1️⃣ Scripts de creación de objetos

*Archivo:* 01_create_tables.sql
Contiene la definición de las tablas principales, relaciones y claves foráneas.

Tablas incluidas:

* proveedores
* componentes
* contratos
* pedidos
* clientes

Cada tabla incluye sus claves primarias, tipos de datos, relaciones y restricciones básicas.

### 2️⃣ Scripts de inserción de registros

*Archivo:* 02_insert_data.sql
Contiene los inserts de datos iniciales de prueba para:

* 5 proveedores globales
* 10 componentes de competición
* 3 contratos vigentes
* 4 pedidos simulados

Estos registros permiten ejecutar pruebas funcionales y validar las relaciones entre entidades.

### 3️⃣ Scripts varios

*Archivo:* 03_misc_scripts.sql
Incluye consultas y operaciones comunes para validación:

* SELECT de unión entre tablas.
* UPDATE y DELETE de mantenimiento.
* Ejemplo de JOIN entre proveedores, contratos y componentes.

---

## 🍃 Sección MongoDB (Base de datos NoSQL)

### 1️⃣ Scripts de creación de colecciones

*Archivo:* 01_create_collections.js
Define las colecciones:

* bitacora_operaciones
* evaluaciones_proveedores
* documentos_legales

### 2️⃣ Scripts de inserción de documentos

*Archivo:* 02_insert_documents.js
Inserta ejemplos de documentos:

* Logs del sistema (usuario, acción, timestamp).
* Evaluaciones de proveedores con criterios de calidad, puntualidad y soporte.
* Metadatos de documentos legales asociados a contratos.

### 3️⃣ Scripts varios

*Archivo:* 03_misc_scripts.js
Incluye operaciones de agregación y consulta:

* Búsqueda por proveedor y fecha.
* Estadísticas de desempeño promedio por proveedor.
* Ejemplo de updateOne y deleteMany.

---

## ⚙️ Requisitos de entorno

* *Sistema operativo:* Ubuntu 22.04 LTS
* *MySQL Server:* 8.0+
* *MongoDB:* 6.0+
* *Cliente de base de datos:* MySQL Workbench o DataGrip
* *CLI MongoDB:* mongosh

---

## 🚀 Ejecución

1. Crear la base de datos relacional:

   bash
   mysql -u root -p < scripts/mysql/01_create_tables.sql
   mysql -u root -p < scripts/mysql/02_insert_data.sql
   

2. Ejecutar los scripts de MongoDB:

   bash
   mongosh < scripts/mongodb/01_create_collections.js
   mongosh < scripts/mongodb/02_insert_documents.js
   

3. (Opcional) Ejecutar los scripts varios para verificar integridad:

   bash
   mysql -u root -p < scripts/mysql/03_misc_scripts.sql
   mongosh < scripts/mongodb/03_misc_scripts.js
   

---

## 📖 Notas finales

* Los scripts fueron probados en *Ubuntu 22.04* , Mysql-Workbench y *MongoDB 6.0*.
* La configuración de conexión está definida en el archivo application.properties de Spring Boot.
* Las inserciones se diseñaron para mantener consistencia entre las fuentes de datos relacional y no relacional.

---

*© Proyecto académico – Bases de Datos II – 2025*
